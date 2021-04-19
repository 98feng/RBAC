package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.*;
import com.bjpowernode.crm.workbench.service.ActivityService;
import com.bjpowernode.crm.workbench.service.ClueService;
import com.bjpowernode.crm.workbench.service.ClueActivityRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 动力节点
 * 2021/3/31
 */
@Controller
public class ClueController {

    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private ClueService clueService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ClueActivityRelationService clueActivityRelationService;


    @RequestMapping("/workbench/clue/index.do")
    public String index(Model model){
        //取所有用户
        List<User> userList=userService.queryAllUsers();
        //对应的字典值集合 appellation clueState source
        List<DicValue> dicValueList=dicValueService.queryDicValueByTypeCode("appellation");
        List<DicValue> clueStateList=dicValueService.queryDicValueByTypeCode("clueState");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");

        model.addAttribute("userList", userList);
        model.addAttribute("dicValueList", dicValueList);
        model.addAttribute("clueStateList", clueStateList);
        model.addAttribute("sourceList", sourceList);

        return "workbench/clue/index";

    }

    @RequestMapping("/workbench/clue/saveCreateClue.do")
    public @ResponseBody Object saveCreateClue(Clue clue, HttpSession session) {
        User user = (User) session.getAttribute(Contants.SESSION_USER);
        //参数已经全部给了
        clue.setId(UUIDUtils.getUUID());
        clue.setCreateBy(user.getId());
        clue.setCreateTime(DateUtils.formatDateTime(new Date()));

        ReturnObject returnObject=new ReturnObject();
        try{
            int ret = clueService.saveCreateClue(clue);
            if(ret>0){
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            }else{
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("插入线索失败");
            }
        }catch(Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("插入线索失败");
        }

        return returnObject;
    }

    //处理线索详情
    @RequestMapping("/workbench/clue/detailClue.do")
    public String detailClue(String id,Model model){
        //id去线索的详情
        Clue clue=clueService.queryClueFOrDetailById(id);
        //List<ClueRemark> remarkList=clueRemarkService.queryRemarkForDetailByClueId(Id);//根据线索id去找与该线索
        List<Activity> activityList=activityService.queryActivityForDetailByClueId(id);

        model.addAttribute("clue",clue);
        model.addAttribute("activityList",activityList);

        return "workbench/clue/detail";
    }

    //查找未绑定的市场活动
    @RequestMapping("/workbench/clue/searchActivityNoBoundById.do")
    public @ResponseBody Object searchActivityNoBoundById(String activityName,String clueId ){
        Map<String,Object> map=new HashMap<>();

        map.put("activityName",activityName);
        map.put("clueId",clueId);

        List<Activity> activityList=activityService.searchActivityNotBoundById(map);
        //返回是一个市场活动的集合
        return activityList;
    }

    @RequestMapping("/workbench/clue/saveUnbundActivity.do")
    public @ResponseBody Object saveUnbundActivity(ClueActivityRelation relation){

        ReturnObject returnObject=new ReturnObject();
        int ret= clueActivityRelationService.deleteClueActivityRelationByClueIdAndActivityId(relation);

        if(ret>0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }

        return returnObject;
    }

    @RequestMapping("/workbench/clue/saveBundActivity.do")
    public @ResponseBody Object saveBundActivity(String clueId,String[] activityId){
        //封装参数
        ClueActivityRelation relation=null;
        //接受ClueActivityRelation的集合
        List<ClueActivityRelation> relationList=new ArrayList<>();
        //对activityId数组进行循环，每次循环时都生一个ClueActivityRelation对象
        for(String ai:activityId){
            relation=new ClueActivityRelation();
            relation.setId(UUIDUtils.getUUID());
            relation.setClueId(clueId);
            relation.setActivityId(ai);
            relationList.add(relation);
        }
        ReturnObject returnObject=new ReturnObject();
        int ret=clueActivityRelationService.saveCreateClueActivityRelationByList(relationList);
        if(ret>0) {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            //将现在关联的市场活动查询出来（3，4）
            List<Activity> activityList=activityService.queryActivityForDetailByIds(activityId);
            returnObject.setRetData(activityList);
        }



        return returnObject;
    }


    @RequestMapping("/workbench/clue/searchActivity.do")
    public @ResponseBody Object searchActivity(String activityName,String clueId){
         List<Activity> activityList=activityService.queryActivityForDetailByName(activityName);
         return  activityList;
    }

    @RequestMapping("/workbench/clue/convertClue.do")
    public String convertClue(String id,Model model){
        //根据线索获取线索的详情
        Clue clue=clueService.queryClueFOrDetailById(id);
        //stage所对应的字典值
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");

        model.addAttribute("clue",clue);
        model.addAttribute("stageList",stageList);
        return  "workbench/clue/convert";
    }

    @RequestMapping("/workbench/clue/saveConvertClue.do")
    public @ResponseBody Object saveConvertClue(String clueId,String isCreateTran,String amountOfMoney, String tradeName,String expectedClosingDate,String stage,String activityId,HttpSession session){
        System.out.println("ok");
        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("clueId",clueId);
        map.put("isCreateTran",isCreateTran);
        map.put("amountOfMoney",amountOfMoney);
        map.put("tradeName",tradeName);
        map.put("expectedClosingDate",expectedClosingDate);
        map.put("stage",stage);
        map.put("activityId",activityId);
        map.put("sessionUser",session.getAttribute(Contants.SESSION_USER));

        ReturnObject returnObject=new ReturnObject();
        try{
            //如何转换线索成功
            clueService.saveConvert(map);
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("线索转换失败");
        }
        return returnObject;
    }

}




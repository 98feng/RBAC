package com.bjpowernode.crm.workbench.web.controller;

import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.DicValue;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.DicValueService;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.Customer;
import com.bjpowernode.crm.workbench.domain.Tran;
import com.bjpowernode.crm.workbench.domain.TranHistory;
import com.bjpowernode.crm.workbench.domain.TranRemark;
import com.bjpowernode.crm.workbench.mapper.TranRemarkMapper;
import com.bjpowernode.crm.workbench.service.CustomerService;
import com.bjpowernode.crm.workbench.service.TranHistoryService;
import com.bjpowernode.crm.workbench.service.TranRemarkService;
import com.bjpowernode.crm.workbench.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 动力节点
 * 2021/4/8
 */
@Controller
public class TranController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @Autowired
    private DicValueService dicValueService;

    @Autowired
    private TranService tranService;

    @Autowired
    private TranRemarkService tranRemarkService;

    @Autowired
    private TranHistoryService tranHistoryService;

    @RequestMapping("/workbench/transaction/typeahead.do")
    public @ResponseBody Object typeahead(String customerName){
        //先不从数据获取，模拟一些数据
        List<Customer> customerList=new ArrayList<>();

        //创建一些客户
        Customer customer=new Customer();
        customer.setId("1001");
        customer.setName("动力节点");
        customerList.add(customer);

        customer=new Customer();
        customer.setId("1002");
        customer.setName("字点跳动");
        customerList.add(customer);

        return customerList;
    }


    //跳转到交易的首页面
    @RequestMapping("/workbench/transaction/index.do")
    public String index(){
        return "workbench/transaction/index";
    }

    //跳转到创建交易页面（类型，来源，阶段）
    @RequestMapping("/workbench/transaction/createTran.do")
    public String createTran(Model model){
        //user
        List<User> userList=userService.queryAllUsers();
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        List<DicValue> transactionTypeList=dicValueService.queryDicValueByTypeCode("transactionType");
        List<DicValue> sourceList=dicValueService.queryDicValueByTypeCode("source");

        model.addAttribute("stageList",stageList);
        model.addAttribute("userList",userList);
        model.addAttribute("transactionTypeList",transactionTypeList);
        model.addAttribute("sourceList",sourceList);
        return "workbench/transaction/save";
    }


    @RequestMapping("/workbench/transaction/queryCustomerByName.do")
    public @ResponseBody Object queryCustomerByName(String customerName){
        List<Customer> customersList=customerService.queryCustomerByName(customerName);
        return customersList;
    }

    @RequestMapping("/workbench/transaction/getPossibilityByStageValue.do")
    public @ResponseBody Object getPossibilityByStageValue(String stageValue){
        //读取属性文件
        ResourceBundle bundle=ResourceBundle.getBundle("possibility");
        String possibility=bundle.getString(stageValue); //根据key取value（分值）
        return possibility;
    }

    //创建交易
    @RequestMapping("/workbench/transaction/saveCreateTran.do")
    public @ResponseBody Object saveCreateTran(Tran tran, String customerName, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        //完善tran对象中的属性
        tran.setId(UUIDUtils.getUUID());
        tran.setCreateBy(user.getId());
        tran.setCreateTime(DateUtils.formatDateTime(new Date()));

        //封装参数
        Map<String,Object> map=new HashMap<>();
        map.put("tran",tran);
        map.put("customerName",customerName);
        map.put("sessionUser",user);

        ReturnObject returnObject=new ReturnObject();
        //调用业务层
        tranService.saveCreateTran(map);

        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);


        return returnObject;
    }

    //交易的详情页面
    @RequestMapping("/workbench/transaction/detailTran.do")
    public String detailTran(String id,Model model){
        //获取所有的阶段
        List<DicValue> stageList=dicValueService.queryDicValueByTypeCode("stage");
        //交易信息详细情况
        Tran tran=tranService.queryTranForDetailById(id);
        //交易备注
        List<TranRemark> remarkList=tranRemarkService.queryTranRemarkForDetailByTranId(id);
        //交易的历史
        List<TranHistory> tranHistoryList=tranHistoryService.queryTranHistoryForDetailByTranId(id);
        //获取交易阶段所对应的分值
        ResourceBundle bundle=ResourceBundle.getBundle("possibility");
        String possibility=bundle.getString(tran.getStage());
        tran.setPossibility(possibility);

        //将数据封装到model
        model.addAttribute("stageList",stageList);
        model.addAttribute("tran",tran);
        model.addAttribute("remarkList",remarkList);
        model.addAttribute("tranHistoryList",tranHistoryList);

        //获取交易在失败之彰最后一个成功的阶段的orderNo
        TranHistory tranHistory=null;
        for(int i=tranHistoryList.size()-1;i>=0;i--){
            tranHistory=tranHistoryList.get(i);
            model.addAttribute("theOrderNo",tranHistory.getOrderNo());
            break;
        }

        return "workbench/transaction/detail";

    }



}

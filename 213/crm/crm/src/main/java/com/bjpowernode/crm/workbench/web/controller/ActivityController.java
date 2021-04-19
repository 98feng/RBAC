package com.bjpowernode.crm.workbench.web.controller;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleSelectSubqueryTableSource;
import com.bjpowernode.crm.commons.contants.Contants;
import com.bjpowernode.crm.commons.domain.ReturnObject;
import com.bjpowernode.crm.commons.utils.DateUtils;
import com.bjpowernode.crm.commons.utils.UUIDUtils;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.service.UserService;
import com.bjpowernode.crm.workbench.domain.Activity;
import com.bjpowernode.crm.workbench.service.ActivityService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.rmi.activation.ActivationID;
import java.util.*;

/**
 * 动力节点
 * 2021/3/26
 */
@Controller
public class ActivityController {

    @Autowired
    private UserService userService;


    @Autowired
    private ActivityService activityService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(Model model){

        List<User> userList=userService.queryAllUsers();
        model.addAttribute("userList",userList);

        return "workbench/activity/index";
    }

    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    public @ResponseBody Object saveCreateActivity(Activity activity, HttpSession session){
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateBy(user.getId());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));

        //返回对象
        ReturnObject returnObject=new ReturnObject();

        int ret=activityService.saveCreateActivity(activity);

        if(ret>0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }else{
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("保存失败");

        }

        return returnObject;
    }



    @RequestMapping("/workbench/activity/queryActivityForPageByCondition.do")
    public @ResponseBody Object queryActivityForPageByCondition(int pageNo,int pageSize,String name,
                                                                String owner,String startDate,String endDate){
        System.out.println("ok");
        Map<String,Object> map=new HashMap<>();
        map.put("beginNo",(pageNo-1)*pageSize); //当前页，limit beginNo
        map.put("pageSize",pageSize);
        map.put("name",name);
        map.put("owner",owner);
        map.put("startDate",startDate);
        map.put("endDate",endDate);

        List<Activity> activityList=activityService.queryActivityForPageByCondition(map);
        long totalRows=activityService.queryCountOfActivityByCondition(map);

        //定义Map来封装返回的对象，不用ReturnObject
        Map<String,Object> retMap=new HashMap<>();
        retMap.put("activityList",activityList);
        retMap.put("totalRows",totalRows);

        return retMap;
    }


    //进入修改页面，id传过来，找Activity,然后将它传到编辑页面
    @RequestMapping("/workbench/activity/editActivity.do")
    public @ResponseBody Object editActivity(String id){
        Activity activity=activityService.queryActivityById(id);
        return activity;
    }

    @RequestMapping("/workbench/activity/saveEditActivity.do")
    public @ResponseBody Object saveEditActivity(Activity activity,HttpSession session){

        User user=(User)session.getAttribute(Contants.SESSION_USER);
        activity.setEditBy(user.getId());
        activity.setEditTime(DateUtils.formatDateTime(new Date()));

        //返回对象
        ReturnObject returnObject=new ReturnObject();

        int ret=activityService.saveEditActivity(activity);

        if(ret>0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }else{
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("修改失败");

        }

        return returnObject;
    }


    @RequestMapping("/workbench/activity/deleteActivityByIds.do")
    public @ResponseBody Object deleteActivityByIds(String[] id){
        //返回对象
        ReturnObject returnObject=new ReturnObject();

        int ret=activityService.deleteActivityByIds(id);

        if(ret>0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
        }else{
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("删除失败");

        }

        return returnObject;
    }

    @RequestMapping("workbench/activity/exportAllActivity.do")
    public void exportAllActivity(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //将市场活动全部取出
        List<Activity> activityList=activityService.queryAllActivityForDetail();
        //要将集合中的市场活动放到excel
        //创建excel
        HSSFWorkbook wb=new HSSFWorkbook();
        HSSFSheet sheet=wb.createSheet("市场活动列表");
        HSSFRow row=sheet.createRow(0);//第一行
        //创建三列
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("ID");
        cell=row.createCell(1);
        cell.setCellValue("所有者");
        cell=row.createCell(2);
        cell.setCellValue("名称");
        cell=row.createCell(3);
        cell.setCellValue("开始日期");
        cell=row.createCell(4);
        cell.setCellValue("结束日期");
        cell=row.createCell(5);
        cell.setCellValue("成本");
        cell=row.createCell(6);
        cell.setCellValue("描述");
        cell=row.createCell(7);
        cell.setCellValue("创建者");
        cell=row.createCell(8);
        cell.setCellValue("创建时间");
        cell=row.createCell(9);
        cell.setCellValue("修改者");
        cell=row.createCell(10);
        cell.setCellValue("修改时间");

        //样式对象
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);

        if(activityList!=null){
            Activity activity=null;
            //通过循环取出每一个activity对象，取数据从第1个开始取
            for(int i=0;i<activityList.size();i++){
                activity=activityList.get(i);
                //创建行从第二行开始
                row=sheet.createRow(i+1);
                cell=row.createCell(0);
                cell.setCellValue(activity.getId());
                cell=row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell=row.createCell(2);
                cell.setCellValue(activity.getName());
                cell=row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell=row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell=row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell=row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell=row.createCell(7);
                cell.setCellValue(activity.getCreateBy());
                cell=row.createCell(8);
                cell.setCellValue(activity.getCreateTime());
                cell=row.createCell(9);
                cell.setCellValue(activity.getEditBy());
                cell=row.createCell(10);
                cell.setCellValue(activity.getEditTime());

            }
        }

        //下载：由服务器向客户端传数据，html,stream
        response.setContentType("application/octet-stream;charset=UTF-8");
        String fileName= URLEncoder.encode("市场活动列表","UTF-8");
        //下载
        String browser=request.getHeader("User-Agent");
        if(browser.contains("firefox")){ //iso8859-1
            fileName=new String("市场活动列表".getBytes("UTF-8"),"ISO8859-1");

        }

        //设置响应头信息
        response.addHeader("Content-Disposition","attachment;filename="+fileName+".xls");


        OutputStream os=response.getOutputStream();
        wb.write(os);
        os.flush();
        os.close();
        wb.close();

    }

    @RequestMapping("/workbench/acitivity/fileUpload.do")
    public @ResponseBody Object fileUpload(String username, MultipartFile myFile) throws Exception{
        //拿上传文件名
        String orignnalFilename=myFile.getOriginalFilename();
        File file=new File("d:\\testDir",orignnalFilename);
        myFile.transferTo(file);

        ReturnObject returnObject=new ReturnObject();
        returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);

        return returnObject;
    }

    @RequestMapping("/workbench/activity/importActivity.do")
    public @ResponseBody Object importActivity(String username, MultipartFile activityFile,HttpSession session) throws Exception{
        //System.out.println("ok");
        User user=(User)session.getAttribute(Contants.SESSION_USER);
        Map<String,Object> retMap=new HashMap<>();

        //市场活动的集合来收集市场活动对象
        List<Activity> activityList=new ArrayList<>();
        //将上传的excel转成inputStream对象
        InputStream is=activityFile.getInputStream();
        //将上传的excel做为输入流给HSSFWorkbook
        HSSFWorkbook wb=new HSSFWorkbook(is);
        //获取第一页
        HSSFSheet sheet=wb.getSheetAt(0);

        //行，列，市场活动对象
        HSSFRow row=null;
        HSSFCell cell=null;
        Activity activity=null;
        int numx=sheet.getLastRowNum();
        System.out.println("numx"+numx);
        //循环取数据
        for(int i=1;i<=sheet.getLastRowNum();i++){
            row=sheet.getRow(i);
            activity=new Activity();
            //每一个市场活动对象都有的属性
            activity.setId(UUIDUtils.getUUID());
            activity.setOwner(user.getId());
            activity.setCreateBy(user.getId());
            activity.setCreateTime(DateUtils.formatDateTime(new Date()));

            for(int j=0;j<row.getLastCellNum();j++){
                cell=row.getCell(j);
                String cellValue=getCellValue(cell);
                if(j==0){
                    activity.setName(cellValue); //市场活动的名称
                } if(j==1){
                    activity.setStartDate(cellValue); //开始时间
                }
                if(j==2){
                    activity.setEndDate(cellValue); //结束时间
                }
                if(j==3){
                    activity.setCost(cellValue); //成本
                }
                if(j==4){
                    activity.setDescription(cellValue); //描述
                }
            }
            activityList.add(activity);
        }

        //批量插入
        int ret=activityService.saveCreateActivityByList(activityList);
        retMap.put("code",Contants.RETURN_OBJECT_CODE_SUCCESS);
        retMap.put("count",ret);

        return retMap;
    }

    //根据单元格不同类型转成字符串
    public static String getCellValue(HSSFCell cell){
        String ret="";
        switch (cell.getCellType()){
            case HSSFCell.CELL_TYPE_STRING:
                ret=cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                ret=cell.getBooleanCellValue()+"";
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                ret=cell.getNumericCellValue()+"";
                break;
            case HSSFCell.CELL_TYPE_FORMULA:
                ret=cell.getCellFormula()+"";
                break;
            default:
                ret="";
        }
        return ret;
    }






}

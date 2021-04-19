package com.bjpowernode.jdbc001.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 动力节点
 * 2021/1/23
 */
public class JdbcUtil {

     private PreparedStatement ps =null;
     private Connection con = null;

    //封装：连接通道创建功能
    public Connection getCon()throws Exception{
        String userName="root";
        String password="123";
        String url ="jdbc:mysql://localhost:3306/bjpowerode";
        con = DriverManager.getConnection(url, userName, password);
        return con;
    }


    //封装:交通工具创建功能
    public PreparedStatement createStatement(String sql)throws Exception{
            ps = getCon().prepareStatement(sql);
            return ps;
    }

    //封装：推送DML语句
    public int executeUpate(String dml)throws Exception{
        int result =0;
        result = createStatement(dml).executeUpdate();
        return result;
    }

    /*
    * 开闭原则:在方法编写完毕之后，意味着方法维护通道已经被关闭
    *         在类文件编写完毕之后，意味着类文件维护通道已经打开，
    *         可以根据业务变更增加类文件属性和方法
    *
    * 方法重载:
    *         1.方法重载基于开闭原则的体现
    *         2.在一个类文件中允许存在多个方法名相同，但是参数列表不同同名
    *
    */
    //资源销毁
    public void close()throws Exception{

        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
    }

    public void close(ResultSet table)throws Exception{

        if(table!=null){
            table.close();
        }
        close();
    }
}

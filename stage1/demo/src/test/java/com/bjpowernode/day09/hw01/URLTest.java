package com.bjpowernode.day09.hw01;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class URLTest {

    @Test
    public void test() {
        String strURL = "http://www.baihe.com/register?name=yang&name=yang&gender=male&interest=drink&interest=smoking&interest=game";
        String strAllParam = getParam(strURL);
        System.out.println(strAllParam);

        Map<String, String> urlRequest = getURLRequest(strURL);
        System.out.println(urlRequest);
        //{gender=male, interest=drink,smoking,game, name=yang,yang}
    }

    /**
     * 去掉url中的路径，对参数判空，留下请求参数部分
     *
     * @param strURL url地址
     * @return url请求参数部分
     */
    private static String getParam(String strURL) {
        String strParam = null;
        String[] arrSplit = null;

        arrSplit = strURL.split("[?]");

        if (arrSplit[1] != null) {
            strParam = arrSplit[1];
        }
        return strParam;
    }

    /**
     * 解析出url参数中的键值对
     *
     * @param URL
     * @return
     */
    private static Map<String, String> getURLRequest(String URL) {
        Map<String, String> mapRequest = new HashMap();
        String[] arrSplit = null;
        //获取url?后面的字符串
        String strUrlParam = getParam(URL);
        if (strUrlParam == null) {
            return mapRequest;
        }

        arrSplit = strUrlParam.split("[&]");
        //遍历每个&分割的字符串数组
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            //每个&分割的数组在根据=分割
            arrSplitEqual = strSplit.split("[=]");
            if (!mapRequest.containsKey(arrSplitEqual[0])) {
                mapRequest.put(arrSplitEqual[0], (arrSplitEqual[1]));
            } else {
                //如果键值相同
                StringBuilder sb = new StringBuilder();
                String values = mapRequest.get(arrSplitEqual[0]);
                sb.append(values).append(",").append(arrSplitEqual[1]);
                mapRequest.put(arrSplitEqual[0], sb.toString());
            }
        }
        return mapRequest;
    }
}


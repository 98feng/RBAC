package com.bjpowernode.controller;

import com.bjpowernode.domain.ProductInfo;
import com.bjpowernode.domain.ProductInfoExample;
import com.bjpowernode.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author feng
 * @date 2021/3/12
 * @Description
 */
@Controller
@RequestMapping("/prod")
public class ProductController {
    @Autowired
    ProductInfoService ps;

    @RequestMapping("/split")
    public String split() {
        ProductInfoExample example = new ProductInfoExample();
        List<ProductInfo> productInfos = ps.selectByExample(example);
        if (!productInfos.isEmpty()) {

            return "product";
        }
        return "";
    }
}

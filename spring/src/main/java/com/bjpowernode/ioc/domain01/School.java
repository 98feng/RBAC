package com.bjpowernode.ioc.domain01;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
@Data
@Component
public class School {
    @Value("陕西电子")
    private String name;
    @Value("西安")
    private String addr;
}

package com.bjpowernode.ioc.domain02;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
@Data
@NoArgsConstructor
@Component
public class Student {
    @Value("zhansgan")
    private String name;
    @Value("19")
    private Integer age;
    @Autowired
    @Qualifier("mySchool")
    private School school;

}

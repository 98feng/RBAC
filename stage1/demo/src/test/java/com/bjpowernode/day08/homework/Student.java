package com.bjpowernode.day08.homework;

import com.sun.istack.internal.NotNull;
import lombok.*;

/**
 * @author feng
 * @date 2020/12/25
 * @Description
 */
@ToString
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
    @NotNull private String no;
    @NotNull private int grade;
    @NotNull private Integer score;
}

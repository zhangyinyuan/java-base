package com.yuan.ngu.java.base.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * StudentVO
 *
 * @author zhangyinyuan
 * @create 2018-05-20 17:26
 **/
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentVO {
    private int studentId;
    private String studentName;
    private String sex;
}

package com.yuan.ngu.java.base.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentPO {
    private Integer studentId;
    private String studentName;
    private char sex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentPO studentPO = (StudentPO) o;
        return sex == studentPO.sex &&
                Objects.equals(studentId, studentPO.studentId) &&
                Objects.equals(studentName, studentPO.studentName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(studentId, studentName, sex);
    }
}

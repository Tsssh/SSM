package cn.tsh.study.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 惠普
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Student {
    private String name;

    private Integer age;

    private String course;

    private String score;


}
package cn.tsh.study.mapper;

import cn.tsh.study.model.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(int i);
}
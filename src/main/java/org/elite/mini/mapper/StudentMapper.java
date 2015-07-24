package org.elite.mini.mapper;

import org.elite.mini.bean.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByAccount(String account);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
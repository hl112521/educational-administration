package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.Student;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface StudentDao extends Mapper<Student>{
    // 根据学号获取学生信息
    Student getUser(String id);
    List<Student> getUserByCollege(String college);

    void updateBirthday(Date birthday,String id);


    List<Student> findClassesListName(String name);

    List<Student> getUserByClasses(String classes);
}

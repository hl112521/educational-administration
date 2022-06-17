package com.zijin.educationaladministration.service;


import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.domain.Student;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface StudentService {
    Student getUser(String id);

    PageResult searchStudent(Map searchMap);
    PageResult searchStudentTeacher(Map searchMap);
    PageResult searchStudentManage(Map searchMap);

    Student findById(String id);

    void update(Student student);
    void updateBirthday(Date birthday,String id);

    void del(String id);

    public void add(Student student);

    List<Student> findClassesListName(String name);

    List<Student> getUserByCollege(String college);
    List<Student> getUserByClasses(String classes);

}

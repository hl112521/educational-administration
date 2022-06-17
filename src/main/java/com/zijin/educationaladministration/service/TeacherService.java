package com.zijin.educationaladministration.service;


import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.domain.Teacher;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TeacherService {
    List<Teacher> findInstructorList(String college);

    Teacher getUser(String id);

    Teacher findById(String id);

    void update(Teacher teacher);
    void updateBirthday(Date birthday, String id);

    void del(String id);

    public void add(Teacher teacher);

    PageResult searchTeacherManage(Map searchMap);

    List<Teacher> getUserByCollege(String college);
}

package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.Teacher;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.List;

@Repository
public interface TeacherDao extends Mapper<Teacher>{
    List<Teacher> findInstructorList(String college);

    Teacher getUserTeacher(String id);
    List<Teacher> getUserByCollege(String college);

    void updateBirthday(Date birthday, String id);
}

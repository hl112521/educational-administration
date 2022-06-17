package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.Classes;
import com.zijin.educationaladministration.domain.Major;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.time.Year;
import java.util.List;

@Repository
public interface ClassesDao extends Mapper<Classes>{
    List<Classes> findClassesList(String major);
    List<Classes> getClassesByCollege(String college);
    List<Classes> getClassesByCollegeANDMajor(String college, String major);
    List<Classes> getInstructorByClaases(String classes);
    List<Classes> getClassesByMajor(String major);

    List<Classes> findClassesInstructor(String name);

    void updateByName(String id, String name, Year grade, String instructor, String college, String major, String nameL);
    Classes findByName(String name);
    void deleteByName(String name);

}

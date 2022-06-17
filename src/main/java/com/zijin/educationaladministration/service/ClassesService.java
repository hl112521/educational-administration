package com.zijin.educationaladministration.service;


import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.domain.Classes;
import com.zijin.educationaladministration.domain.Major;

import java.time.Year;
import java.util.List;
import java.util.Map;

public interface ClassesService {
    List<Classes> findClasses(String major);

    List<Classes> findClassesList();
    List<Classes> getClassesByCollege(String college);
    List<Classes> getClassesByCollegeANDMajor(String college, String major);
    List<Classes> getInstructorByClaases(String classes);
    List<Classes> getClassesByMajor(String major);

    List<Classes> findClassesInstructor(String name);

    PageResult searchclassesManage(Map searchMap);
    Classes findById(String id);
    Classes findByName(String name);

    void update(String id, String name, Year grade, String instructor, String college, String major, String nameL);

    void del(String name);

    void add(Classes classes);


}

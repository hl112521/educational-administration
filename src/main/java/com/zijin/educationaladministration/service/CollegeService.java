package com.zijin.educationaladministration.service;


import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.domain.College;

import java.util.List;
import java.util.Map;

public interface CollegeService {
    List<College> findCollegeList();
    List<College> findCollegeDean(String name);

    PageResult searchcollegeManage(Map searchMap);

    College findById(String id);

    void update(String id, String name, String dean, String nameL);

    void del(String id);

    void add(College college);
}

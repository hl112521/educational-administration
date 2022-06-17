package com.zijin.educationaladministration.service;


import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.domain.College;
import com.zijin.educationaladministration.domain.Major;

import java.util.List;
import java.util.Map;

public interface MajorService {
    List<Major> findMajorList();
    List<Major> findMajorListCollege(String college);


    PageResult searchmajorManage(Map searchMap);
    Major findById(String id);
    Major findByName(String name);

    void update(String id, String name, String college, String nameL);

    void del(String name);

    void add(Major major);
}

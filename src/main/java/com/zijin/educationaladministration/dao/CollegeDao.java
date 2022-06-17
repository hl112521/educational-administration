package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.College;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CollegeDao extends Mapper<College>{
    List<College> findCollegeDean(String name);
    void updateByName(String id, String name, String dean, String nameL);
}

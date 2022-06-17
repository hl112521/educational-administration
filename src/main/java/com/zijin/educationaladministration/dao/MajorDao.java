package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.Major;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MajorDao extends Mapper<Major>{
    List<Major> getMajorByCollege(String college);

    Major findByName(String name);
    void updateByName(String id, String name, String college, String nameL);
    void deleteByName(String name);

}

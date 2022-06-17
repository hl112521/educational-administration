package com.zijin.educationaladministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.dao.CollegeDao;
import com.zijin.educationaladministration.dao.MajorDao;
import com.zijin.educationaladministration.domain.College;
import com.zijin.educationaladministration.domain.Major;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.CollegeService;
import com.zijin.educationaladministration.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeDao collegeDao;

    @Override
    public List<College> findCollegeList() {
        List<College> colleges = collegeDao.selectAll();
        return colleges;
    }

    @Override
    public List<College> findCollegeDean(String name) {
        List<College> collegeDean = collegeDao.findCollegeDean(name);
        return collegeDean;
    }

    @Override
    public PageResult searchcollegeManage(Map searchMap) {
        //指定查询的表
        Example example = new Example(College.class);
        if (searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            if (StringUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name + "%");
            }
            int pageNum = 1; //默认值
            int pageSize = 2; //默认值
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
            // 特别注意: 该行代码后面要紧跟要执行的查询语句
            PageHelper.startPage(pageNum, pageSize);
        }
        example.setOrderByClause("id");
        Page<College> page = (Page<College>) collegeDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.COLLEGE_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public College findById(String id) {
        return collegeDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(String id, String name, String dean, String nameL) {
        collegeDao.updateByName(id, name, dean, nameL);
    }

    @Override
    public void del(String id) {
        collegeDao.deleteByPrimaryKey(id);
    }

    @Override
    public void add(College college) {

        collegeDao.insertSelective(college);
    }
}

package com.zijin.educationaladministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.dao.MajorDao;
import com.zijin.educationaladministration.domain.College;
import com.zijin.educationaladministration.domain.Major;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class MajorServiceImpl implements MajorService {

    @Autowired
    private MajorDao majorDao;

    @Override
    public List<Major> findMajorList() {
        List<Major> majors = majorDao.selectAll();
        return majors;
    }

    @Override
    public List<Major> findMajorListCollege(String college) {
        List<Major> majors = majorDao.getMajorByCollege(college);
        return majors;
    }

    @Override
    public PageResult searchmajorManage(Map searchMap) {
        //指定查询的表
        Example example = new Example(Major.class);
        if (searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            if (StringUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name + "%");
            }
            String college = (String) searchMap.get("college");
            if (college.equals("全部"))
                college = null;
            if (StringUtil.isNotEmpty(college)) {
                criteria.andLike("college", "%" + college + "%");
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
        Page<Major> page = (Page<Major>) majorDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.MAJOR_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public Major findById(String id) {
        return majorDao.selectByPrimaryKey(id);
    }

    @Override
    public Major findByName(String name) {
        Major majors = majorDao.findByName(name);
        return majors;
    }

    @Override
    public void update(String id, String name, String college, String nameL) {
        majorDao.updateByName(id, name, college, nameL);
    }

    @Override
    public void del(String name) {
        majorDao.deleteByName(name);
    }

    @Override
    public void add(Major major) {

        majorDao.insertSelective(major);
    }
}

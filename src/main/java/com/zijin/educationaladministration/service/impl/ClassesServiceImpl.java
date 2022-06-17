package com.zijin.educationaladministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.dao.ClassesDao;
import com.zijin.educationaladministration.dao.MajorDao;
import com.zijin.educationaladministration.domain.Classes;
import com.zijin.educationaladministration.domain.Major;
import com.zijin.educationaladministration.service.ClassesService;
import com.zijin.educationaladministration.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.time.Year;
import java.util.List;
import java.util.Map;

@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesDao classesDao;

    @Override
    public List<Classes> findClasses(String major) {
        List<Classes> classes = classesDao.findClassesList(major);
        return classes;
    }
    @Override
    public List<Classes> findClassesList() {
        List<Classes> classes = classesDao.selectAll();
        return classes;
    }

    @Override
    public List<Classes> getClassesByCollege(String college) {
        List<Classes> classes = classesDao.getClassesByCollege(college);
        return classes;
    }

    @Override
    public List<Classes> getClassesByCollegeANDMajor(String college, String major) {
        List<Classes> classes = classesDao.getClassesByCollegeANDMajor(college, major);
        return classes;
    }

    @Override
    public List<Classes> getInstructorByClaases(String classes) {
        List<Classes> classesL = classesDao.getInstructorByClaases(classes);
        return classesL;
    }

    @Override
    public List<Classes> getClassesByMajor(String major) {
        List<Classes> classesByMajor = classesDao.getClassesByMajor(major);
        return classesByMajor;
    }

    @Override
    public List<Classes> findClassesInstructor(String name) {
        List<Classes> classes = classesDao.findClassesInstructor(name);
        return classes;
    }

    @Override
    public PageResult searchclassesManage(Map searchMap) {
        //指定查询的表
        Example example = new Example(Classes.class);
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
        example.setOrderByClause("college");
        Page<Classes> page = (Page<Classes>) classesDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.CLASSES_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public Classes findById(String id) {
        return classesDao.selectByPrimaryKey(id);
    }

    @Override
    public Classes findByName(String name) {
        Classes classes = classesDao.findByName(name);
        return classes;
    }

    @Override
    public void update(String id, String name, Year grade, String instructor, String college, String major, String nameL) {
        classesDao.updateByName(id, name, grade, instructor, college, major, nameL);
    }

    @Override
    public void del(String name) {
        classesDao.deleteByName(name);
    }

    @Override
    public void add(Classes classes) {

        classesDao.insertSelective(classes);
    }

}

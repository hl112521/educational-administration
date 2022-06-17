package com.zijin.educationaladministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.dao.StudentDao;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getUser(String id) {
        return studentDao.getUser(id);
    }

    @Override
    public PageResult searchStudent(Map searchMap) {
        //指定查询的表
        Example example = new Example(Student.class);
        if (searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            if (StringUtil.isNotEmpty(name)) {
                criteria.andLike("name", "%" + name + "%");
            }
            String classes = (String) searchMap.get("classes");
            if (StringUtil.isNotEmpty(classes)) {
                criteria.andLike("classes", "%" + classes + "%");
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
        Page<Student> page = (Page<Student>) studentDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.STUDENT_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public PageResult searchStudentTeacher(Map searchMap) {
        //指定查询的表
        Example example = new Example(Student.class);
        if (searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            if (StringUtil.isNotEmpty(name)) {

                criteria.andLike("name", "%" + name + "%");
            }
            String classerList = (String) searchMap.get("classes");
            String[] split = classerList.split(",");
            List<String> arr = Arrays.asList(split);
            if (split.length != 0) {
                criteria.andIn("classes", arr);
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
        Page<Student> page = (Page<Student>) studentDao.selectByExample(example);

        return new PageResult(true, StatusCode.OK, MessageConstant.STUDENT_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public PageResult searchStudentManage(Map searchMap) {

        //指定查询的表
        Example example = new Example(Student.class);
        if (searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String) searchMap.get("name");
            if (StringUtil.isNotEmpty(name)) {

                criteria.andLike("name", "%" + name + "%");
            }
            String collegeList = (String) searchMap.get("college");
            String majorList = (String) searchMap.get("major");
            String classesList = (String) searchMap.get("classes");
            if (collegeList.equals("全部") && majorList.equals("全部") && classesList.equals("全部")){

            } else if (!collegeList.equals("全部") && majorList.equals("全部") && classesList.equals("全部") ) {
                criteria.andLike("college", "%" + collegeList + "%");
            } else if (!majorList.equals("全部") && collegeList.equals("全部") && classesList.equals("全部") ){
                criteria.andLike("major", "%" + majorList + "%");
            } else if (!classesList.equals("全部") && majorList.equals("全部") && collegeList.equals("全部")) {
                criteria.andLike("classes", "%" + classesList + "%");
            } else if (!classesList.equals("全部")) {
                criteria.andLike("classes", "%" + classesList + "%");
            } else if (!majorList.equals("全部")) {
                criteria.andLike("major", "%" + majorList + "%");
            } else if (!collegeList.equals("全部")) {
                criteria.andLike("college", "%" + collegeList + "%");
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
        Page<Student> page = (Page<Student>) studentDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.STUDENT_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public Student findById(String id) {
        return studentDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(Student student) {
        studentDao.updateByPrimaryKey(student);
    }
    @Override
    public void updateBirthday(Date birthday, String id) {
        studentDao.updateBirthday(birthday, id);
    }

    @Override
    public void del(String id) {
        studentDao.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Student student) {

        studentDao.insertSelective(student);
    }

    @Override
    public List<Student> findClassesListName(String name) {
        List<Student> classes = studentDao.findClassesListName(name);
        return classes;
    }

    @Override
    public List<Student> getUserByCollege(String college) {
        List<Student> userByCollege = studentDao.getUserByCollege(college);
        return userByCollege;
    }

    @Override
    public List<Student> getUserByClasses(String classes) {
        List<Student> studentList = studentDao.getUserByClasses(classes);
        return studentList;
    }
}

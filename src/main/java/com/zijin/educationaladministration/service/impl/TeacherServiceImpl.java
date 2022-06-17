package com.zijin.educationaladministration.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.dao.TeacherDao;
import com.zijin.educationaladministration.domain.Teacher;
import com.zijin.educationaladministration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> findInstructorList(String college) {
        List<Teacher> teachers = teacherDao.findInstructorList(college);
        return teachers;
    }

    @Override
    public Teacher getUser(String id) {
        return teacherDao.getUserTeacher(id);
    }

    @Override
    public Teacher findById(String id) {
        return teacherDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.updateByPrimaryKey(teacher);
    }

    @Override
    public void updateBirthday(Date birthday,String id) {
        teacherDao.updateBirthday(birthday, id);
    }

    @Override
    public void del(String id) {
        teacherDao.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Teacher teacher) {

        teacherDao.insertSelective(teacher);
    }

    @Override
    public PageResult searchTeacherManage(Map searchMap) {
        //指定查询的表
        Example example = new Example(Teacher.class);
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
        Page<Teacher> page = (Page<Teacher>) teacherDao.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.TEACHER_SEARCH_SUCCESS, page.getResult(), page.getTotal());
    }

    @Override
    public List<Teacher> getUserByCollege(String college) {
        List<Teacher> userByCollege = teacherDao.getUserByCollege(college);
        return userByCollege;
    }

}

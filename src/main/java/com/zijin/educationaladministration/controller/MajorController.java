package com.zijin.educationaladministration.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.College;
import com.zijin.educationaladministration.domain.Major;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.ClassesService;
import com.zijin.educationaladministration.service.MajorService;
import com.zijin.educationaladministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@RestController
public class MajorController {
    @Autowired
    MajorService majorService;
    @Autowired
    ClassesService classesService;

    @RequestMapping("/getMajor")
    public List<Major> getMajor() {
        List<Major> majorList = majorService.findMajorList();
        return majorList;
    }

    @RequestMapping("/getMajorByCollege")
    public List<Major> getMajorByCollege(@RequestParam("college")String college) {
        List<Major> majorList = majorService.findMajorListCollege(college);
        return majorList;
    }

    @RequestMapping("/searchmajorManage")
    public PageResult searchcollegeManage(@RequestBody Map map) {
        PageResult result = majorService.searchmajorManage(map);
        return result;
    }

    @RequestMapping("/addmajor")
    public Result add(@RequestBody Major major) {
        if (majorService.findByName(major.getName()) != null)
            return new Result(false, StatusCode.ERROR, MessageConstant.MAJOR_ADD_ERROR);
        else {
            majorService.add(major);
            return new Result(true, StatusCode.OK, MessageConstant.MAJOR_ADD_SUCCESS);
        }

    }

    @RequestMapping("/findByNamemajor")
    public Result findByName(String name) {
        Major major = majorService.findByName(name);
        return new Result(true, StatusCode.OK, MessageConstant.MAJOR_FIND_BY_ID_SUCCESS, major);
    }

    @RequestMapping("/updatemajor")
    public Result update(@RequestParam("nameL") String nameL,@RequestBody Major major) {
        majorService.update(major.getId(), major.getName(), major.getCollege(), nameL);
        return new Result(true, StatusCode.OK, MessageConstant.MAJOR_UPDATE_SUCCESS, major);
    }

    @RequestMapping("/delmajor")
    public Result del(String name) {
        if (classesService.getClassesByMajor(name).size()!=0) {
            return new Result(false, StatusCode.ERROR, MessageConstant.MAJOR_DELETE_ERROR);
        } else {
            majorService.del(name);
            return new Result(true, StatusCode.OK, MessageConstant.COLLEGE_DELETE_SUCCESS);
        }
    }
}

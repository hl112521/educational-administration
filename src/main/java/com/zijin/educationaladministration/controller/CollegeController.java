package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.College;
import com.zijin.educationaladministration.service.ClassesService;
import com.zijin.educationaladministration.service.CollegeService;
import com.zijin.educationaladministration.service.StudentService;
import com.zijin.educationaladministration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CollegeController {
    @Autowired
    CollegeService collegeService;
    @Autowired
    ClassesService classesService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;



    @RequestMapping("/getCollege")
    public List<College> getCollege() {
        List<College> classes = collegeService.findCollegeList();
        return classes;
    }

    @RequestMapping("/searchcollegeManage")
    public PageResult searchcollegeManage(@RequestBody Map map) {
        PageResult result = collegeService.searchcollegeManage(map);
        return result;
    }

    @RequestMapping("/addcollege")
    public Result add(@RequestBody College college) {
        if (collegeService.findById(college.getId()) != null)
            return new Result(false, StatusCode.ERROR, MessageConstant.COLLEGE_ADD_ERROR);
        else {
            collegeService.add(college);
            return new Result(true, StatusCode.OK, MessageConstant.COLLEGE_ADD_SUCCESS);
        }

    }

    @RequestMapping("/findByIdcollege")
    public Result findById(String id) {
        College college = collegeService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.COLLEGE_FIND_BY_ID_SUCCESS, college);
    }

    @RequestMapping("/updatecollege")
    public Result update(@RequestParam("nameL") String nameL, @RequestBody College college) {
        collegeService.update(college.getId(), college.getName(), college.getDean(), nameL);
        return new Result(true, StatusCode.OK, MessageConstant.COLLEGE_UPDATE_SUCCESS, college);
    }

    @RequestMapping("/delcollege")
    public Result del(String id) {
        College col = collegeService.findById(id);
        if ((classesService.getClassesByCollege(col.getName())).size()!=0 || (studentService.getUserByCollege(col.getName())).size()!=0 || (teacherService.getUserByCollege(col.getName())).size()!=0) {
            return new Result(false, StatusCode.ERROR, MessageConstant.COLLEGE_DELETE_ERROR);
        } else {
            collegeService.del(id);
            return new Result(true, StatusCode.OK, MessageConstant.COLLEGE_DELETE_SUCCESS);
        }
    }
}

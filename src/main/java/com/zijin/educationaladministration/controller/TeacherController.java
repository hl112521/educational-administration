package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.Teacher;
import com.zijin.educationaladministration.service.ClassesService;
import com.zijin.educationaladministration.service.CollegeService;
import com.zijin.educationaladministration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassesService classesService;
    @Autowired
    CollegeService collegeService;

    @RequestMapping("/getInstructor")
    public List<Teacher> getInstructor(@RequestParam("college")String college) {
        List<Teacher> teachers = teacherService.findInstructorList(college);
        return teachers;
    }

    @RequestMapping("/findByIdTeacher")
    public Result findById(String id) {
        Teacher teacher = teacherService.getUser(id);
        return new Result(true, StatusCode.OK, MessageConstant.TEACHER_FIND_BY_ID_SUCCESS, teacher);
    }

    @RequestMapping("/updateTeacher")
    public Result update(@RequestBody Teacher teacher) {
        Date birthday = teacher.getBirthday();
        teacherService.update(teacher);
        teacherService.updateBirthday(birthday,teacher.getId());
        return new Result(true, StatusCode.OK, MessageConstant.TEACHER_UPDATE_SUCCESS, teacher);
    }

    @RequestMapping("/addTeacher")
    public Result add(@RequestBody Teacher teacher) {
        if (teacherService.findById(teacher.getId()) != null)
            return new Result(false, StatusCode.ERROR, MessageConstant.TEACHER_ADD_ERROR);
        else {
            teacherService.add(teacher);
            return new Result(true, StatusCode.OK, MessageConstant.TEACHER_ADD_SUCCESS);
        }
    }

    @RequestMapping("/delTeacher")
    public Result del(String id) {
        if ((collegeService.findCollegeDean(teacherService.findById(id).getName())).size() != 0) {
            return new Result(false, StatusCode.ERROR, MessageConstant.TEACHER_DELETE_ERROR_DEAN);
        }
        if ((classesService.findClassesInstructor(teacherService.findById(id).getName())).size() != 0){
            return new Result(false, StatusCode.ERROR, MessageConstant.TEACHER_DELETE_ERROR);
        }
        else {
            teacherService.del(id);
            return new Result(true, StatusCode.OK, MessageConstant.TEACHER_DELETE_SUCCESS);
        }

    }

    @RequestMapping("/searchTeacherManage")
    public PageResult searchTeacherManage(@RequestBody Map map) {
        PageResult result = teacherService.searchTeacherManage(map);
        return result;
    }
}

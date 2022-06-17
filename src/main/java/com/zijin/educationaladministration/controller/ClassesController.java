package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.Classes;
import com.zijin.educationaladministration.domain.Major;
import com.zijin.educationaladministration.service.ClassesService;
import com.zijin.educationaladministration.service.MajorService;
import com.zijin.educationaladministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ClassesController {
    @Autowired
    ClassesService classesService;
    @Autowired
    StudentService studentService;

    @RequestMapping("/getClasses")
    public List<Classes> getClasses(@RequestParam("major")String major) {
        List<Classes> classesList = classesService.findClasses(major);
        return classesList;
    }

    @RequestMapping("/getClassesList")
    public List<Classes> getClasses() {
        List<Classes> classesList = classesService.findClassesList();
        return classesList;
    }

    @RequestMapping("/getClassesByCollege")
    public List<Classes> getClassesByCollege(@RequestParam("college")String college) {
        List<Classes> classesList = classesService.getClassesByCollege(college);
        return classesList;
    }

    @RequestMapping("/getClassesByCollegeANDMajor")
    public List<Classes> getClassesByCollegeANDMajor(@RequestParam("college")String college, @RequestParam("major")String major) {
        List<Classes> classesList = classesService.getClassesByCollegeANDMajor(college, major);
        return classesList;
    }

    @RequestMapping("/getInstructorByClaases")
    public List<Classes> getInstructorByClaases(@RequestParam("classes")String classes) {
        List<Classes> classesList = classesService.getInstructorByClaases(classes);
        return classesList;
    }

    @RequestMapping("/searchclassesManage")
    public PageResult searchcollegeManage(@RequestBody Map map) {
        PageResult result = classesService.searchclassesManage(map);
        return result;
    }

    @RequestMapping("/addclasses")
    public Result add(@RequestBody Classes classes) {
        if (classesService.findByName(classes.getName()) != null)
            return new Result(false, StatusCode.ERROR, MessageConstant.CLASSES_ADD_ERROR);
        else {
            classesService.add(classes);
            return new Result(true, StatusCode.OK, MessageConstant.CLASSES_ADD_SUCCESS);
        }

    }

    @RequestMapping("/findByNameclasses")
    public Result findByName(String name) {
        Classes classes = classesService.findByName(name);
        return new Result(true, StatusCode.OK, MessageConstant.CLASSES_FIND_BY_ID_SUCCESS, classes);
    }

    @RequestMapping("/updateclasses")
    public Result update(@RequestParam("nameL") String nameL,@RequestBody Classes classes) {
        classesService.update(classes.getId(), classes.getName(), classes.getGrade(), classes.getInstructor(), classes.getCollege(), classes.getMajor(), nameL);
        return new Result(true, StatusCode.OK, MessageConstant.CLASSES_UPDATE_SUCCESS, classes);
    }

    @RequestMapping("/delclasses")
    public Result del(String name) {
        if (studentService.getUserByClasses(name).size()!=0) {
            return new Result(false, StatusCode.ERROR, MessageConstant.CLASSES_DELETE_ERROR);
        } else {
            classesService.del(name);
            return new Result(true, StatusCode.OK, MessageConstant.CLASSES_DELETE_SUCCESS);
        }
    }
}

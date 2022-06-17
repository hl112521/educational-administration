package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.PageResult;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/searchStudent")
    public PageResult searchStudent(@RequestBody Map map) {
        PageResult result = studentService.searchStudent(map);
        return result;
    }
    @RequestMapping("/searchStudentTeacher")
    public PageResult searchStudentTeacher(@RequestBody Map map) {
        PageResult result = studentService.searchStudentTeacher(map);
        return result;
    }

    @RequestMapping("/searchStudentManage")
    public PageResult searchStudentManage(@RequestBody Map map) {
        PageResult result = studentService.searchStudentManage(map);
        return result;
    }

    @RequestMapping("/addStudent")
    public Result add(@RequestBody Student student) {
        if (studentService.findById(student.getId()) != null)
            return new Result(false, StatusCode.ERROR, MessageConstant.STUDENT_ADD_ERROR);
        else {
            studentService.add(student);
            return new Result(true, StatusCode.OK, MessageConstant.STUDENT_ADD_SUCCESS);
        }

    }

    @RequestMapping("/findByIdStudent")
    public Result findById(String id) {
        Student student = studentService.findById(id);
        return new Result(true, StatusCode.OK, MessageConstant.STUDENT_FIND_BY_ID_SUCCESS, student);
    }

    @RequestMapping("/updateStudent")
    public Result update(@RequestBody Student student) {
        Date birthday = student.getBirthday();
        studentService.update(student);
        studentService.updateBirthday(birthday, student.getId());
        return new Result(true, StatusCode.OK, MessageConstant.STUDENT_UPDATE_SUCCESS, student);
    }

    @RequestMapping("/delStudent")
    public Result del(String id) {
        studentService.del(id);
        return new Result(true, StatusCode.OK, MessageConstant.STUDENT_DELETE_SUCCESS);
    }

    @RequestMapping("/getClassesTeacher")
    public List<Student> getClassesTeacher(@RequestParam("name")String name, HttpServletResponse response) {
        List<Student> classesList = studentService.findClassesListName(name);
        if (classesList.size() == 0) {
            Cookie cookie = new Cookie("noclasses", "yes");
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("noclasses", "no");
            response.addCookie(cookie);
        }
        return classesList;
    }
}

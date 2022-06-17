package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.domain.Account;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.domain.Teacher;
import com.zijin.educationaladministration.service.AccountService;
import com.zijin.educationaladministration.service.StudentService;
import com.zijin.educationaladministration.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AccountService accountService;
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    /**
     * 用于返回登录页面
     * @param request 判断是否已经登录，已经登录就直接跳转
     * @return  返回登录页面模板
     */
    @RequestMapping("/iflogs")
    public void iflogs( HttpServletRequest request,
                       HttpServletResponse response) {
        HttpSession session = request.getSession();     // 获取用户登录信息
        String account = "",role = "", student_name="", student_classes = "", student_college = "", student_major = "";
        // 如果已经登录，则重定向直接跳转到判断界面
        Cookie cok_user = new Cookie("user", account);
        Cookie cok_role = new Cookie("role", role);
        Cookie cok_name = new Cookie("name", student_name);
        Cookie cok_classes = new Cookie("classes", student_classes);
        Cookie cok_college = new Cookie("college", student_college);
        Cookie cok_major = new Cookie("major", student_major);
        if (session.getAttribute("user") != null) {
            Account acc = (Account)session.getAttribute("user");
            account = acc.getAccount();
            role = acc.getRole();
            if (role.equals("student")){
                Student student = studentService.getUser(account);
                student_name = student.getName();
                student_classes = student.getClasses();
                student_college = student.getCollege();
                student_major = student.getMajor();
            }
        }else {
            account = "error";
            role = "error";
            student_name = "error";
            student_classes = "error";
            student_college = "error";
            student_major = "error";
        }
        cok_user.setValue(account);
        cok_role.setValue(role);
        cok_name.setValue(student_name);
        cok_classes.setValue(student_classes);
        cok_college.setValue(student_college);
        cok_major.setValue(student_major);
        response.addCookie(cok_user);
        response.addCookie(cok_role);
        response.addCookie(cok_name);
        response.addCookie(cok_classes);
        response.addCookie(cok_college);
        response.addCookie(cok_major);
    }

    @RequestMapping("/iflogt")
    public void iflogt( HttpServletRequest request,
                       HttpServletResponse response) {
        HttpSession session = request.getSession();     // 获取用户登录信息
        String account = "",role = "", techer_name="", teacher_college = "";
        // 如果已经登录，则重定向直接跳转到判断界面
        Cookie cok_user = new Cookie("user", account);
        Cookie cok_role = new Cookie("role", role);
        Cookie cok_name = new Cookie("name", techer_name);
        Cookie cok_college = new Cookie("college", teacher_college);
        if (session.getAttribute("user") != null) {
            Account acc = (Account)session.getAttribute("user");
            account = acc.getAccount();
            role = acc.getRole();
            if (role.equals("teacher")){
                Teacher teacher = teacherService.getUser(account);
                techer_name = teacher.getName();
                teacher_college = teacher.getCollege();
            }
        }else {
            account = "error";
            role = "error";
            techer_name = "error";
            teacher_college = "error";
        }
        cok_user.setValue(account);
        cok_role.setValue(role);
        cok_name.setValue(techer_name);
        cok_college.setValue(teacher_college);
        response.addCookie(cok_user);
        response.addCookie(cok_role);
        response.addCookie(cok_name);
        response.addCookie(cok_college);
    }

    @RequestMapping("/iflogm")
    public void iflogm( HttpServletRequest request,
                       HttpServletResponse response) {
        HttpSession session = request.getSession();     // 获取用户登录信息
        String account = "",role = "", manager_name="系统管理员";
        // 如果已经登录，则重定向直接跳转到判断界面
        Cookie cok_user = new Cookie("user", account);
        Cookie cok_role = new Cookie("role", role);
        Cookie cok_name = new Cookie("name", manager_name);
        if (session.getAttribute("user") != null) {
            Account acc = (Account)session.getAttribute("user");
            account = acc.getAccount();
            role = acc.getRole();
        }else {
            account = "error";
            role = "error";
            manager_name = "error";
        }
        cok_user.setValue(account);
        cok_name.setValue(manager_name);
        cok_role.setValue(role);
        response.addCookie(cok_user);
        response.addCookie(cok_name);
        response.addCookie(cok_role);
    }

    /**
     * 用于验证账号和密码是否正确
     *
     * @param account   账号信息
     * @param password   密码信息
     * @param request    用于获取Session
     * @return 登录成功跳转管理界面，失败返回错误信息到登录页面
     */
//    @RequestMapping("/manage/verification")        // 失败错误信息页面网址
    @RequestMapping("/login")
    public String verification(@RequestParam("account") String account,
                               @RequestParam("password") String password,
                               HttpServletRequest request) {
        if (account.equals("") || password.equals("")) {   // 密码为空，重新登录
            return "redirect:index.html";
        } else {
            Account userAccount = accountService.login(account, password);  // 从数据库中获得与输入相同的用户
            if (userAccount == null) {         // 没有该用户
                return "redirect:index.html";
            }
            // 创建 session

            HttpSession session = request.getSession();
            session.setAttribute("user", userAccount);
        }
        return "redirect:/manage";             // 登录成功进行页面选择跳转
    }

    @RequestMapping("/logout")
    public void logout( HttpServletRequest request,
                       HttpServletResponse response) {

        HttpSession session = request.getSession();
        session.setAttribute("user", null);
    }
}

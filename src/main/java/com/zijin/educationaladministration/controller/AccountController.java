package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.Account;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * 后台管理页面数据准备接口
     * @param request 用于获取Session来判断是否登录
     * @return 返回模板页面
     */

    @RequestMapping("/manage")      // 管理页面网址
    public String manage(HttpServletRequest request){
        HttpSession session=request.getSession();       // 获取登录信息
        Object obj = session.getAttribute("user");
        session.setAttribute("user", session.getAttribute("user"));
        // 没有登录，返回登录页面
        if(obj == null){     // 登录信息为 null，表示没有登录
            return "redirect:/login";
        }

        Account loginAccount = (Account) obj;                    // 强制转换成 Account
        String users = loginAccount.getAccount();         // 获得登录用户的 账号
        String role = accountService.getUserRoleByAccount(users);      // 通过登录用户的 账号 得到用户的角色
        // 如果是学生登录，返回学生界面
        if (role.equals("student")){
            return "redirect:student.html";
        }
        // 如果是老师登录，返回老师界面
        else if (role.equals("teacher")) {
            return "redirect:teacher.html";
        }
        // 如果是管理员登录就返回管理页面
        return "redirect:manager.html";
    }

}

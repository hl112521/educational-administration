package com.zijin.educationaladministration.controller;

import com.zijin.educationaladministration.common.MessageConstant;
import com.zijin.educationaladministration.common.Result;
import com.zijin.educationaladministration.common.StatusCode;
import com.zijin.educationaladministration.domain.Account;
import com.zijin.educationaladministration.domain.Student;
import com.zijin.educationaladministration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AccountUpdateController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/updateStudentPassword")
    public Result updateStudentPassword(String password, String password_con, HttpServletRequest request) {
        HttpSession session=request.getSession();       // 获取登录信息
        Account acc = (Account)session.getAttribute("user");
        if (password.equals(acc.getPassword())){
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR_AGREEMENT, null);
        }
        else if (password.equals(password_con)) {
            acc.setPassword(password);
            accountService.update(acc);
            return new Result(true, StatusCode.OK, MessageConstant.ACCOUNT_UPDATE_SUCCESS, acc);
        }
        else {
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR, null);
        }
    }

    @RequestMapping("/updateTeacherPassword")
    public Result updateTeacherPassword(String password, String password_con, HttpServletRequest request) {
        HttpSession session=request.getSession();       // 获取登录信息
        Account acc = (Account)session.getAttribute("user");
        if (password.equals(acc.getPassword())){
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR_AGREEMENT, null);
        }
        else if (password.equals(password_con)) {
            acc.setPassword(password);
            accountService.update(acc);
            return new Result(true, StatusCode.OK, MessageConstant.ACCOUNT_UPDATE_SUCCESS, acc);
        }
        else {
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR, null);
        }
    }

    @RequestMapping("/updateManagerPassword")
    public Result updateManagerPassword(String password, String password_con, HttpServletRequest request) {
        HttpSession session=request.getSession();       // 获取登录信息
        Account acc = (Account)session.getAttribute("user");
        if (password.equals(acc.getPassword())){
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR_AGREEMENT, null);
        }
        else if (password.equals(password_con)) {
            acc.setPassword(password);
            accountService.update(acc);
            return new Result(true, StatusCode.OK, MessageConstant.ACCOUNT_UPDATE_SUCCESS, acc);
        }
        else {
            return new Result(false, StatusCode.ERROR, MessageConstant.ACCOUNT_UPDATE_ERROR, null);
        }
    }

}

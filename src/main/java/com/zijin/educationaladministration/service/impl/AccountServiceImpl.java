package com.zijin.educationaladministration.service.impl;

import com.zijin.educationaladministration.dao.AccountDao;
import com.zijin.educationaladministration.domain.Account;
import com.zijin.educationaladministration.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account login(String account, String password) {
        return accountDao.login(account, password);
    }

    @Override
    public String getUserRoleByAccount(String account) {
        return accountDao.getUserRoleByAccount(account);
    }

    @Override
    public void update(Account account) {
        accountDao.updateByPrimaryKey(account);
    }
}

package com.zijin.educationaladministration.service;

import com.zijin.educationaladministration.domain.Account;

public interface AccountService {
    public Account login(String account, String password);

    public String  getUserRoleByAccount(String account);

    void update(Account account);

}

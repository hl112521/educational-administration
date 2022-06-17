package com.zijin.educationaladministration.dao;

import com.zijin.educationaladministration.domain.Account;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.spring.annotation.MapperScan;

@Repository
public interface AccountDao extends Mapper<Account>{

    // 根据用户名和密码获得用户信息
    Account login(String account, String password);

    String getUserRoleByAccount(String account);
}

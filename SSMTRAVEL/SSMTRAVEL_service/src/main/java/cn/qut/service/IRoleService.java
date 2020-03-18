package cn.qut.service;

import cn.qut.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;
}

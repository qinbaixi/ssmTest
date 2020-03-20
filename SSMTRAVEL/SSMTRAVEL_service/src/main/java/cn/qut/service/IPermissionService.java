package cn.qut.service;

import cn.qut.domain.Permission;
import cn.qut.domain.Role;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    List<Role> findOtherRoleByPermissionId(String id) throws Exception;

    void addPermissionToRole(String permissionId,String[] roleIds)throws Exception;

    Permission findById(String id) throws Exception;
}

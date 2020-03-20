package cn.qut.service.impl;

import cn.qut.dao.IPermissionDao;
import cn.qut.domain.Permission;
import cn.qut.domain.Role;
import cn.qut.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
       permissionDao.save(permission);
    }

    @Override
    public List<Role> findOtherRoleByPermissionId(String id) throws Exception {
        return permissionDao.findOtherRoleByPermissionId(id);
    }

    @Override
    public void addPermissionToRole(String permissionId, String[] roleIds) throws Exception {
        for (String roleId : roleIds
        ) {
            permissionDao.addPermissionToRole(permissionId,roleId);
        }
    }

    @Override
    public Permission findById(String id) throws Exception {
        return permissionDao.findById(id);
    }
}

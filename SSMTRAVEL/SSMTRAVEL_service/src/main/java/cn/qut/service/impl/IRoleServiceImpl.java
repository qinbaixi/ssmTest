package cn.qut.service.impl;

import cn.qut.dao.IRoleDao;
import cn.qut.domain.Permission;
import cn.qut.domain.Role;
import cn.qut.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }

    @Override
    public void deleteRoleById(String roleId) throws Exception {
        roleDao.deleteRoleById(roleId);
    }
}

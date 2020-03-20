package cn.qut.dao;

import cn.qut.domain.Permission;
import cn.qut.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;


    @Select("select * from role where id not in (select roleid from ROLE_PERMISSION where permissionid=#{id})")
    List<Role> findOtherRoleByPermissionId(String id) throws Exception;



    @Insert("insert into role_permission(permissionid,roleid) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("permissionId") String permissionId, @Param("roleId") String roleId) throws Exception;

    @Select("select * from permission where id=#{id}")
    Permission findById(String id)throws  Exception;
}

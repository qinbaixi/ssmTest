package cn.qut.controller;

import cn.qut.domain.Permission;
import cn.qut.domain.Role;
import cn.qut.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermissionService permissionService;


    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id" ,required=true) String id) throws Exception {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("permission-show");
        mv.addObject("permission", permissionService.findById(id));

        return mv;
    }

    @RequestMapping("/addRoleToPermission.do")
    public String addRoleToPermission(@RequestParam(name = "permissionId", required = true) String permissionId, @RequestParam(name = "ids", required = true)String[] roleIds) throws Exception {
        permissionService.addPermissionToRole(permissionId,roleIds);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findOtherRoleByPermissionId.do")
    public ModelAndView findOtherRoleByPermissionId(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role>  roleList=  permissionService.findOtherRoleByPermissionId(id);
        mv.addObject("permission",permissionService.findById(id));
        mv.addObject("roleList", roleList);
        mv.setViewName("permission-role-add");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
}

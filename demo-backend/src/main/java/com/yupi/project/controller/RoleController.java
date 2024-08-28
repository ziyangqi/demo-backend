package com.yupi.project.controller;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.model.entity.Role;
import com.yupi.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public BaseResponse<List<Role>> getRole() {
        return roleService.getRole();
    }
    @GetMapping("/{userId}")
    public BaseResponse<String> getRoles(@PathVariable Long userId) {
        return roleService.getRoleById(userId);
    }
    @PostMapping("/add/{role}")
    public BaseResponse<String> addRole(@PathVariable String role) {
        roleService.addRole(role);
        return ResultUtils.success("ok");
    }
    @PostMapping("/bind/{userId}/{roleId}")
    public BaseResponse<String> bindRole(@PathVariable Long roleId,@PathVariable Long userId) {
        roleService.bindRole(userId, roleId);
        return ResultUtils.success("ok");
    }
}

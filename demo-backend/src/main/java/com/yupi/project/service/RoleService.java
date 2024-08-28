package com.yupi.project.service;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.model.entity.Role;

import java.util.List;

public interface RoleService {
    BaseResponse<List<Role>> getRole();

    void addRole(String role);

    void bindRole(Long userId, Long roleId);

    BaseResponse<String> getRoleById(Long userId);
}

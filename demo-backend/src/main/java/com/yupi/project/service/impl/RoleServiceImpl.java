package com.yupi.project.service.impl;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.mapper.RoleMapper;
import com.yupi.project.model.entity.Role;
import com.yupi.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public BaseResponse<List<Role>> getRole() {
        return roleMapper.select();
    }
    @Override
    public void addRole(String role) {
        roleMapper.insert(role);
    }

    @Override
    public void bindRole(Long userId, Long roleId) {
        roleMapper.insert(userId, roleId);
    }

    @Override
    public BaseResponse<List<String>> getRoleById(Long userId) {
        return roleMapper.selectById(userId);
    }
}

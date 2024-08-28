package com.yupi.project.mapper;

import com.yupi.project.common.BaseResponse;
import com.yupi.project.model.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select * from role")
    BaseResponse<List<Role>> select();
    @Insert("insert into role(role_name)values(#{role})")
    void insert(String role);
    @Insert(("insert into user_role(user_id,role_id)values (#{userId},#{roleId})"))
    void insert(Long userId, Long roleId);
    @Select("select role_name from user_role left join role " +
            " on user_role.role_id = role.id where user_role.user_id = #{userId}")
    BaseResponse<List<String> > selectById(Long userId);
}

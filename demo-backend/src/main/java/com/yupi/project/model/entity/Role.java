package com.yupi.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class Role {
    private Long id;
    private String roleName;
    public Role(String roleName) {
        this.roleName = roleName;
    }
}

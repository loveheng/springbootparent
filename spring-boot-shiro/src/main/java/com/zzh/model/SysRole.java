package com.zzh.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class SysRole {

    @Id
    @GeneratedValue
    private Integer id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name ="SysRolePermission",joinColumns = {@JoinColumn(name="roleId")},inverseJoinColumns = {@JoinColumn(name="permissionId")})
    private List<SysPermission> permissions;

    @ManyToMany
    @JoinTable(name="SysUserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name="uid")})
    private List<UserInfo> userInfos;



}

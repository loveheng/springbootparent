package com.zzh.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SysPermission {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @Column(columnDefinition = "enum('menu','button')")
    private String resourceType;
    private String url;
    private String permission;
    private Long parentId;
    private String parentIds;
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name="SysRolePermission",joinColumns = {@JoinColumn(name="permissionId")},inverseJoinColumns ={@JoinColumn(name="roleId")} )
    private List<SysRole> roles;

}

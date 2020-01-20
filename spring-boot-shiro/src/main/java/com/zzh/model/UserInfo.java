package com.zzh.model;


import com.sun.javafx.beans.IDProperty;
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
public class UserInfo {

    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private String slat;
    private byte state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns = {@JoinColumn(name="roleId")})
    private List<SysRole> roleList;

    public String getGredentialsSalt() {

        return this.username+this.slat;
    }





}

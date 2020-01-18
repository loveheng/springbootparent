package com.zzh.mybatis.model;

import com.zzh.mybatis.enums.UserSexEnum;
import lombok.*;
import org.springframework.context.annotation.Bean;

@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private Long id;
    private String userName;
    private String passWord;
    private UserSexEnum userSexEnum;
    private String nickName;

    public User() {
        super();
    }

    public User(String userName,String passWord,UserSexEnum userSexEnum) {
        super();
        this.passWord=passWord;
        this.userName=userName;
        this.userName=userName;
    }


}

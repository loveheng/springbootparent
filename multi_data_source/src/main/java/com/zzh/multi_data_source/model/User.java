package com.zzh.multi_data_source.model;

import com.zzh.multi_data_source.enums.UserSexEnum;
import lombok.*;

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

    public User(String userName, String passWord, UserSexEnum userSexEnum) {
        super();
        this.passWord=passWord;
        this.userName=userName;
        this.userName=userName;
    }


}

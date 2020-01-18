package com.zzh.amqp.model;

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
    private String nickName;

    public User() {
        super();
    }

    public User(String userName, String passWord) {
        super();
        this.passWord=passWord;
        this.userName=userName;
        this.userName=userName;
    }


}

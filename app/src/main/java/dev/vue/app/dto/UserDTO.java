package dev.vue.app.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDTO {

    private int no;
    private String name;
    private String email;
    private String pwd;
    private int gender;
    private int del;
    private LocalDateTime regDate;

}

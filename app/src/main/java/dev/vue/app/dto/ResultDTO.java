package dev.vue.app.dto;

import lombok.Data;

@Data
public class ResultDTO {

    private Boolean state;
    private Object result;
    private String message;

}

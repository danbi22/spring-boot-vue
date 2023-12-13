package dev.vue.app.service;

import dev.vue.app.dto.ResultDTO;
import dev.vue.app.dto.UserDTO;

public interface UserService {

    public ResultDTO findAll();
    public ResultDTO editById(UserDTO uDto);
    public ResultDTO delete(int no);
    public ResultDTO save(UserDTO uDto);
}

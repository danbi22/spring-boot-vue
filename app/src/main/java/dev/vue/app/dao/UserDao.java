package dev.vue.app.dao;

import dev.vue.app.dto.UserDTO;

import java.util.List;

public interface UserDao {

    public List<UserDTO> findAll();
    public int delete(int no);
    public int save(UserDTO uDto);
    public int editById(UserDTO uDto);
}

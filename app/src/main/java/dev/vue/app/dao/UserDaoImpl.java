package dev.vue.app.dao;

import dev.vue.app.dto.UserDTO;
import dev.vue.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private UserMapper uMapper;

    @Override
    public List<UserDTO> findAll() {
        return uMapper.findAll();
    }

    @Override
    public int delete(int no) {
        return uMapper.delete(no);
    }

    @Override
    public int save(UserDTO uDto) {
        return uMapper.save(uDto);
    }

    @Override
    public int editById(UserDTO uDto) {
        return uMapper.editById(uDto);
    }
}

package dev.vue.app.mapper;

import dev.vue.app.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user3")
    public List<UserDTO> findAll();

    @Update("update user3 set name = #{name}, email = #{email}, pwd = #{pwd}, gender = #{gender} where no = #{no}")
    public int editById(UserDTO uDTO);

    @Update("update user3 set del = 1 where no = #{no}")
    public int delete(int no);

    @Insert("insert into user3 (name, email, pwd, gender) values (#{name}, #{email}, #{pwd}, #{gender})")
    public int save(UserDTO uDto);
}

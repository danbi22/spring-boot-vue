package dev.vue.app.service;

import dev.vue.app.dao.UserDao;
import dev.vue.app.dto.ResultDTO;
import dev.vue.app.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private ResultDTO rDto;

    @Autowired
    UserDao uDao;

    @Override
    public ResultDTO findAll() {
        rDto = new ResultDTO();
        List<UserDTO> resultList = uDao.findAll();
        if (resultList != null) {
            rDto.setState(true);
            rDto.setResult(resultList);
            for (UserDTO uDto: resultList) {
                log.info("Regdate = "+uDto.getRegDate());
            }
        } else {
            rDto.setState(false);
        }
        return rDto;
    }

    @Override
    public ResultDTO editById(UserDTO uDto) {
        ResultDTO rDto = new ResultDTO();
        int state = uDao.editById(uDto);
        log.info("state = " + state);
        if (state == 1) {
            rDto.setState(true);
            rDto.setMessage("사용자 정보 수정이 성공적으로 완료되었습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 정보 수정이 실패하였습니다.");
        }
        return rDto;
    }

    @Override
    public ResultDTO delete(int no) {
        ResultDTO rDto = new ResultDTO();
        int state = uDao.delete(no);
        if (state == 1) {
            rDto.setState(true);
            rDto.setMessage("사용자 정보 삭제를 성공적으로 완료했습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 정보 삭제를 실패하였습니다.");
        }
        return rDto;
    }

    @Override
    public ResultDTO save(UserDTO uDto) {
        ResultDTO rDto = new ResultDTO();
        int state = uDao.save(uDto);
        if (state == 1) {
            rDto.setState(true);
            rDto.setMessage("사용자 정보를 성공적으로 저장하였습니다.");
        } else {
            rDto.setState(false);
            rDto.setMessage("사용자 정보 저장을 실패하였습니다.");
        }
        return rDto;
    }

}

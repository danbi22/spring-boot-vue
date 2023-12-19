package dev.vue.app.controller;

import dev.vue.app.dto.ResultDTO;
import dev.vue.app.dto.UserDTO;
import dev.vue.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin(origins = "http://localhost:8082")
@RestController
public class DataController {

    @Autowired
    UserService uService;

    @GetMapping("/")
    public String home() {
        return "Data 준비중...";
    }

    @GetMapping("/api")
    public String api() {
        return "API Data 준비중...";
    }

    @PostMapping("/findAll")
    public ResultDTO findAll() {
        return uService.findAll();
    }

    @PostMapping("/editById")
    public ResultDTO editById(@RequestBody UserDTO uDto) {
        log.info("UserDto =" + uDto);
        return uService.editById(uDto);
    }

    @DeleteMapping("/delete")
    public ResultDTO delete(@RequestParam("no") int no) {
        return uService.delete(no);
    }

    @PutMapping("/save")
    public ResultDTO save(@RequestBody UserDTO uDto) {
        log.info(uDto+"");
        return uService.save(uDto);
    }
}

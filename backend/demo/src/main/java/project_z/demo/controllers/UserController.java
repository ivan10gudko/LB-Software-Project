package project_z.demo.controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project_z.demo.Mappers.Mapper;
import project_z.demo.dto.UserDto;
import project_z.demo.entity.UserEntity;
import project_z.demo.services.UserService;



    
@RestController
public class UserController {  

    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/Users")
    public ResponseEntity <UserDto> createUser(@RequestBody UserDto user) {
        UserEntity userEntity = userMapper.mapFrom(user);
        UserEntity savedUserEntity = userService.save(userEntity);
       return new ResponseEntity<>( userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);
        
      
    }
    @GetMapping(path = "/Users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") UUID id){
        Optional<UserEntity> foundUser = userService.findOne(id);
       return foundUser.map(UserEntity -> {
            UserDto userDto  = userMapper.mapTo(UserEntity);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping(path  = "/Users/{Id}")
    public ResponseEntity<UserDto> fullUpdateUser(
        @PathVariable("Id") UUID id,
        @RequestBody UserDto userDto) {
        if(!userService.isExists(id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userDto.setId(id);
        UserEntity userEntity = userMapper.mapFrom(userDto);
    UserEntity savedUserEntity =  userService.save(userEntity);
      return new ResponseEntity<> (userMapper.mapTo(userEntity), HttpStatus.OK);
    }
}

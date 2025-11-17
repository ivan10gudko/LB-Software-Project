package project_z.demo.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project_z.demo.Mappers.Mapper;
import project_z.demo.dto.UserDto;
import project_z.demo.entity.UserEntity;
import project_z.demo.repositories.UserRepository;
import project_z.demo.services.UserService;




    
@RestController
public class UserController {  

    private UserService userService;
    private Mapper<UserEntity, UserDto> userMapper;
    @Autowired 
    private UserRepository userRepository;

    public UserController(UserService userService, Mapper<UserEntity, UserDto> userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping(path = "/Users")
    public ResponseEntity <?> createUser(@RequestBody UserDto user) {
        UserEntity userEntity = userMapper.mapFrom(user);
        if(userRepository.existsByNameTag(userEntity.getNameTag())){
            return ResponseEntity.badRequest()
            .body("NameTag '" + userEntity.getNameTag() + "' already exists");
        }
        UserEntity savedUserEntity = userService.save(userEntity);
        return new ResponseEntity<>( userMapper.mapTo(savedUserEntity), HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/Users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") UUID id){
        Optional<UserEntity> foundUser = userService.findOne(id);
       return foundUser.map(UserEntity -> {
            UserDto userDto  = userMapper.mapTo(UserEntity);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping(path = "/Users/{nameTag}/nameTag")
    public UserDto findUsersByNameTag(@PathVariable("nameTag") String nameTag) {
        UserEntity foundUser = userService.findByNameTag(nameTag).orElseThrow(
            () -> new RuntimeException("user not found")
        );
        UserDto response = userMapper.mapTo(foundUser);
        return response;
    }
    @GetMapping(path = "/users/name/{name}")
    public List<UserDto> findUsersByName(@PathVariable("name")String name) {
        List<UserEntity> userEntitys = userService.findByName(name);
        List<UserDto> response = new ArrayList<>();
        for(UserEntity u : userEntitys){
            UserDto d = userMapper.mapTo(u);
            response.add(d);
        }
        return response;
    }
    
    
    @PutMapping(path  = "/Users/{id}")
    public ResponseEntity<UserDto> fullUpdateUser(
        @PathVariable("id") UUID id,
        @RequestBody UserDto userDto) {
        if(!userService.isExists(id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userDto.setUserId(id);
        UserEntity userEntity = userMapper.mapFrom(userDto);
    UserEntity savedUserEntity =  userService.save(userEntity);
      return new ResponseEntity<> (userMapper.mapTo(savedUserEntity), HttpStatus.OK);
    }


    @PatchMapping(path = "/Users/{id}")
    public ResponseEntity<UserDto> partialUpdate (
        @PathVariable("id") UUID id,@RequestBody UserDto userDto
        ){
             if(!userService.isExists(id)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       UserEntity userEntity = userMapper.mapFrom(userDto);
        UserEntity updatedUserEntity  = userService.partialUpdate(id, userEntity);
        return new ResponseEntity<>(userMapper.mapTo(updatedUserEntity), HttpStatus.OK);
    }
    @PutMapping(path = "/users/avatar/{id}")
    public ResponseEntity<String> changeUserImg(
        @PathVariable("id") UUID id,
        @RequestParam("file") MultipartFile file){
        UserEntity userEntity = userService.findOne(id).orElseThrow(
            () -> new RuntimeException("user not found"));
        
        String response =  userService.uploadAvatar(userEntity,file);
        userEntity.setImg(response);
        userRepository.save(userEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
        
    }
    @DeleteMapping(path = "/Users/{id}")
    public ResponseEntity<Void> deleteUserById(
        @PathVariable("id") UUID id
    ){
         if(!userService.isExists(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
          userService.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

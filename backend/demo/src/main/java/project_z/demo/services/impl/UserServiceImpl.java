package project_z.demo.services.impl;

import org.springframework.stereotype.Service;

import project_z.demo.entity.UserEntity;
import project_z.demo.repositories.UserRepository;
import project_z.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
@Override
public UserEntity createUser(UserEntity userEntity){
    return userRepository.save(userEntity);
    
}
}

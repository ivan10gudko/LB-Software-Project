package project_z.demo.services.impl;

import java.util.Optional;
import java.util.UUID;

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
public UserEntity save(UserEntity userEntity){
    return userRepository.save(userEntity);
    
}
@Override 
public Optional<UserEntity> findOne(UUID id){

return  userRepository.findById(id);
}
@Override
public boolean isExists(UUID id) {
    return userRepository.existsById(id);
}

}

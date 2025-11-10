package project_z.demo.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_z.demo.JavaUtil.BeanUtilsHelper;
import project_z.demo.entity.RoomEntity;
import project_z.demo.entity.UserEntity;
import project_z.demo.repositories.RoomRepository;
import project_z.demo.repositories.TitleRepository;
import project_z.demo.repositories.UserRepository;
import project_z.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final TitleRepository titleRepository;
    @Autowired
    private BeanUtilsHelper beanUtilsHelper;
    private UserRepository userRepository;
    @Autowired
    private RoomRepository roomRepository;
    public UserServiceImpl(UserRepository userRepository, TitleRepository titleRepository){
        this.userRepository = userRepository;
        this.titleRepository = titleRepository;
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
@Override
public UserEntity partialUpdate(UUID id, UserEntity source) {
    return userRepository.findById(id)
        .map(target -> {
            beanUtilsHelper.copyNonNullProperties(source, target);
            return userRepository.save(target);
        })
        .orElseThrow(() -> new RuntimeException("User not found"));
}
@Override
public void deleteById(UUID id){
     UserEntity user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
    for (RoomEntity room : user.getRooms()) {
        room.getMembers().remove(user);
        roomRepository.save(room); 
    }
    user.getRooms().clear();
    userRepository.deleteById(id);
}


}

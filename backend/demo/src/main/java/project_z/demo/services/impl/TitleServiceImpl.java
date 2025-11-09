package project_z.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_z.demo.JavaUtil.BeanUtilsHelper;
import project_z.demo.entity.TitleEntity;
import project_z.demo.entity.UserEntity;
import project_z.demo.repositories.TitleRepository;
import project_z.demo.repositories.UserRepository;
import project_z.demo.services.TitleService;
@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    private BeanUtilsHelper beanUtilsHelper;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private UserRepository userRepository;
@Override
public TitleEntity createTitle(TitleEntity title){
    return titleRepository.save(title);
}
@Override
public List<TitleEntity> findAll(){
   return  StreamSupport.stream( 
        titleRepository.findAll().spliterator(),
        false)
        .collect(Collectors.toList());
}
@Override
public Optional<TitleEntity> findOne(Integer titleId){
    return titleRepository.findById(titleId);
}

@Override
public boolean isExists(Integer titleId){
    return titleRepository.existsById(titleId);
}
@Override
public TitleEntity partialUpdate(Integer titleId, TitleEntity source) {
    return titleRepository.findById(titleId)
        .map(target -> {
            beanUtilsHelper.copyNonNullProperties(source, target);
            return titleRepository.save(target);
        })
        .orElseThrow(() -> new RuntimeException("User not found"));
}
@Override
public void deleteById(Integer Id){
    titleRepository.deleteById(Id);
}
@Override
public List<TitleEntity> addTitle(TitleEntity titleEntity, UUID userId){
    UserEntity userEntity = userRepository.findById(userId).orElseThrow(
        () -> new RuntimeException("user not found"));
        titleEntity.setUser(userEntity);
        userEntity.getTitleList().add(titleEntity);
        userRepository.save(userEntity);
        return userEntity.getTitleList();
}

}
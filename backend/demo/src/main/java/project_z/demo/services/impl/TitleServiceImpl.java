package project_z.demo.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_z.demo.entity.TitleEntity;
import project_z.demo.repositories.TitleRepository;
import project_z.demo.services.TitleService;
@Service
public class TitleServiceImpl implements TitleService {
    @Autowired
    private TitleRepository titleRepository;
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
public Optional<TitleEntity> findOne(int titleId){
    return titleRepository.findById(titleId);
}
}

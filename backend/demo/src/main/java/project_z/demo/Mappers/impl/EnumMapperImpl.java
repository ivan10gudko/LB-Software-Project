package project_z.demo.Mappers.impl;

import org.springframework.stereotype.Component;

import project_z.demo.Mappers.Mapper;
import project_z.demo.entity.TitleEntity;

@Component
public class EnumMapperImpl implements Mapper <TitleEntity.titleStatus, String> {
 
@Override
public String mapTo(TitleEntity.titleStatus source) {
    return source == null ? null :  source.name();
}

@Override 
public TitleEntity.titleStatus mapFrom(String destination){
    return destination == null ? null : TitleEntity.titleStatus.valueOf(destination);
}
}
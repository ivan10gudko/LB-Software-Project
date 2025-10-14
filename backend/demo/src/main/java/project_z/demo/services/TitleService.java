package project_z.demo.services;

import java.util.List;
import java.util.Optional;

import project_z.demo.entity.TitleEntity;

public interface  TitleService {
    TitleEntity createTitle(TitleEntity title );
    List<TitleEntity> findAll();
    Optional<TitleEntity> findOne(Integer titleId);
    boolean isExists (Integer titleId);
    TitleEntity partialUpdate(Integer titleId, TitleEntity titleEntity);
    void deleteById(Integer id);
}

package project_z.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import project_z.demo.entity.TitleEntity;

@Service
public interface  TitleSearchService {
    List<TitleEntity> searchTitle(String text);

}

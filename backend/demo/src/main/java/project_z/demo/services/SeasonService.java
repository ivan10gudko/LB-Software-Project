package project_z.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import project_z.demo.entity.SeasonEntity;

@Service
public interface SeasonService {
    SeasonEntity save(SeasonEntity seasonEntity); 
    List<SeasonEntity> findAll(Long titleId);
}

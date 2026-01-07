package project_z.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project_z.demo.entity.SeasonEntity;
import project_z.demo.repositories.SeasonRepository;
import project_z.demo.services.SeasonService;

@Service
public class SeasonServiceImpl implements SeasonService {
    @Autowired
    private SeasonRepository seasonRepository;
    @Override
    public SeasonEntity save(SeasonEntity seasonEntity){
        return seasonRepository.save(seasonEntity);
    }
    @Override
    public List<SeasonEntity> findAll(Long titleId){
       return StreamSupport.stream(seasonRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
    
}

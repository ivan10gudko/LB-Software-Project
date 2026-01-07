package project_z.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project_z.demo.Mappers.Mapper;
import project_z.demo.dto.SeasonDto;
import project_z.demo.entity.SeasonEntity;
import project_z.demo.services.SeasonService;


@RestController
@RequestMapping("/api/v1/season")
public class SeasonController {
    @Autowired
    private SeasonService seasonService;
    @Autowired 
    private Mapper<SeasonEntity, SeasonDto> seasonMapper;
@GetMapping(path = "/{titleId}")
public List<SeasonDto> getSeasons(@PathVariable("titleId") Long titleId) {
    List<SeasonEntity> entitys = seasonService.findAll(titleId);
    List<SeasonDto> response = new ArrayList<>();
    return seasonService.findAll(titleId).stream().map(a-> seasonMapper.mapTo(a)).collect(Collectors.toList());
}

}

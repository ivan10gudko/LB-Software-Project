package project_z.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project_z.demo.Mappers.Mapper;
import project_z.demo.dto.TitleDto;
import project_z.demo.entity.TitleEntity;
import project_z.demo.services.TitleService;





@RestController
public class TitleController {
@Autowired
private Mapper<TitleEntity, TitleDto> titleMapper;
@Autowired
private TitleService titleService;
@PostMapping("/Titles")
public ResponseEntity <TitleDto> CreateTitle (
    @RequestBody TitleDto titleDto) {
        TitleEntity titleEntity = titleMapper.mapFrom(titleDto);
        TitleEntity savedTitle = titleService.createTitle(titleEntity);
        TitleDto savedTitleDto = titleMapper.mapTo(savedTitle);
    return new ResponseEntity<>(savedTitleDto, HttpStatus.CREATED);
}


@GetMapping("/Titles")
public List<TitleDto> ListTitles(){
     List<TitleEntity> titles = titleService.findAll();
    return titles.stream()
    .map(titleMapper::mapTo)
    .collect(Collectors.toList());
    
}
@GetMapping(path = "/Titles/{titleId}")
public ResponseEntity<TitleDto> getTitle(@PathVariable("titleId") int titleId) {
    Optional<TitleEntity> foundTitle = titleService.findOne(titleId);
    return foundTitle
    .map(TitleEntity ->{
        TitleDto titleDto = titleMapper.mapTo(TitleEntity);
        return new ResponseEntity<>(titleDto , HttpStatus.OK);
        
    }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

}
@PutMapping(path = "/Titles/{titleId}")
public ResponseEntity<TitleDto> fullUpdateTitle (
    @PathVariable("titleId") int titleId,
    @RequestBody TitleDto titleDto
    ) {
    boolean bookExists = titleService.isExists(titleDto.getTitleId());
     TitleEntity titleEntity = titleMapper.mapFrom(titleDto);
        TitleEntity savedTitle = titleService.createTitle(titleEntity);
        TitleDto savedTitleDto = titleMapper.mapTo(savedTitle);
        if(bookExists){
            return new ResponseEntity<>(titleDto, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}
@PatchMapping(path = "/Titles/{titleId}")
    public ResponseEntity<TitleDto> partialUpdate (
        @PathVariable("titleId") int titleId,@RequestBody TitleDto titleDto
        ){
             if(!titleService.isExists(titleId)){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       TitleEntity titleEntity = titleMapper.mapFrom(titleDto);
        TitleEntity updatedTitleEntity  = titleService.partialUpdate(titleId, titleEntity);
        return new ResponseEntity<>(titleMapper.mapTo(updatedTitleEntity), HttpStatus.OK);
    }
    @DeleteMapping(path = "/Titles/{titleId}")
    public ResponseEntity<Void> deleteUserById(
        @PathVariable("titleId") Integer titleId
    ){
         if(!titleService.isExists(titleId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
          titleService.deleteById(titleId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
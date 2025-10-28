package project_z.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project_z.demo.entity.TitleEntity;
import project_z.demo.services.TitleSearchService;
import project_z.demo.services.TranslationService;

@RestController
@RequiredArgsConstructor
public class SearchController {
    
    private final TranslationService translationService;
    private final TitleSearchService titleSearchService;

  /*   @GetMapping(path = "/Search")
    public String TestTransaltion (@RequestParam("q") String text) {
        String translatedService = translationService.translateToEnglish(text);
        return translatedService;
    }
        */
    @GetMapping(path = "/Search")
    public List<TitleEntity> Search(@RequestParam("q") String text) {
         String translatedService = translationService.translateToEnglish(text);
         List<TitleEntity> response = titleSearchService.searchTitle(translatedService);
         return response;
    }
    
    
}

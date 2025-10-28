package project_z.demo.services.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project_z.demo.entity.TitleEntity;
import project_z.demo.services.TitleSearchService;

@Service
public class TitleSeachServiceImpl implements TitleSearchService {
  private final RestTemplate restTemplate = new RestTemplate();
    @Override
   public List <TitleEntity> searchTitle(String text){
    String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
     String url = "https://api.jikan.moe/v4/anime?q="+ encodedText + "&limit=5";
    
     try{
      Map<String, Object> response = restTemplate.getForObject(url, Map.class);
      List<Map<String,Object>> data = ( List<Map<String,Object>>) response.get("data");
      List<TitleEntity> titles = new ArrayList<>();
      for (Map<String, Object> item : data) {
                TitleEntity entity = new TitleEntity();
                entity.setTitleName((String) item.get("title"));
                entity.setApiTitleId((Integer) item.get("mal_id"));
                titles.add(entity);
                
     }
     return titles;
    }
    catch(Exception e){
      e.printStackTrace();
      return List.of();
    }
}
}

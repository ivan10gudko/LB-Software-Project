package project_z.demo.services.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project_z.demo.services.TitleSearchService;

@Service
public class TitleSeachServiceImpl implements TitleSearchService {
  private final RestTemplate restTemplate = new RestTemplate();
    @Override
    public String searchTitle(String text, int page){
    String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
    String url = "https://api.jikan.moe/v4/anime?q="+ encodedText + "&limit=24" +"&page=" + page;
    return restTemplate.getForObject(url, String.class);
    
}
}

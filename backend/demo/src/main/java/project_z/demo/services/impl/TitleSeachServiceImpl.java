package project_z.demo.services.impl;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project_z.demo.services.TitleSearchService;

@Service
public class TitleSeachServiceImpl implements TitleSearchService {
  private final RestTemplate restTemplate = new RestTemplate();
    @Override
   public String searchTitle(String text){
    String encodedText = URLEncoder.encode(text, StandardCharsets.UTF_8);
    String url = "https://api.jikan.moe/v4/anime?q="+ encodedText + "&limit=5";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    String res = restTemplate.getForObject(url, String.class);
    return res;
}
}

package project_z.demo.services.impl;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import project_z.demo.services.TranslationService;

@Service
public class TranslationServiceImpl implements TranslationService {
    private final RestTemplate restTemplate = new RestTemplate();
    @Override
    
    public String translateToEnglish(String text){
        
        String apiKey = "5539d20c91424a044d5f";
        String url  = "http://localhost:5000/translate";
               Map<String, String> requestBody  =  Map.of(
                 "q", text,
                 "source", "auto",
                 "target", "en",
                 "format", "text"
            );
         
        try {
            Map response = restTemplate.postForObject(url, requestBody, Map.class);
            if(response != null && response.containsKey("translatedText")){
                return (String) response.get("translatedText");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}

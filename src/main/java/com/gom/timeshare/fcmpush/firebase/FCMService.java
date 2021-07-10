package com.gom.timeshare.fcmpush.firebase;

import com.gom.timeshare.code.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
public class FCMService {

    @Autowired
    RestTemplate restTemplate;

    public void sendMessage(){

        HttpHeaders header = new HttpHeaders();
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
        body.add("name","HaMyeongDo");
        body.add("project","TimeShare");


        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body,header);



        ResponseEntity<String> re = restTemplate.exchange(Code.FIREBASE_SEND_PUSH.desc
                                    , HttpMethod.POST, entity, String.class);



        System.out.println(re.getBody());
    }
}

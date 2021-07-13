package com.gom.timeshare.fcmpush.firebase;

import com.gom.timeshare.code.Code;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class FCMService {

    private RestTemplate restTemplate;

    public void sendMessage(){
        HttpHeaders header = new HttpHeaders();
        MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();


        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body,header);
        ResponseEntity<String> responseEntity = restTemplate.exchange(Code.FIREBASE_SEND_PUSH.DESC
                                    , HttpMethod.POST, entity, String.class);
    }
}

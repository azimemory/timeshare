package com.gom.timeshare.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

public class MemberController {

    @GetMapping("member/kakao-login")
    public void login(@RequestParam Map<String,String> commandMap){
        System.out.println(commandMap);
    }

}

package com.gom.timeshare.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("member/login")
    public String login(@RequestParam Map<String,String> commandMap){
       return "timetable/timetable";
    }



}

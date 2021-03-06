package com.gom.timeshare.common.code;


public enum Code {
    DOMAIN("http://localhost:9797"), //DOMAIN("http://www.pclass.com")
    EMAIL("killsky2014@naver.com"),
    UPLOAD("C:\\CODE\\afternoon\\E_SERVLET\\resources\\upload\\"),
    FIREBASE_SEND_PUSH("https://fcm.googleapis.com/v1/parent=projects/timetable-for-hyeon/messages:send");
    public final String DESC;

    Code(String desc){
        this.DESC = desc;
    }

    public String toString() {
        return DESC;
    }
}


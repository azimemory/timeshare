package com.gom.timeshare.member;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MemberForm {

    private String userId;
    private String password;
    private String nickName;
    private String gender;
    private String email;
    private String thumbnailUrl;
    private String socialLoginId;
    private LocalDateTime regDate;
    private boolean isLeave;
}

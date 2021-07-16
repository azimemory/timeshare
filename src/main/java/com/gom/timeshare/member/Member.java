package com.gom.timeshare.member;

import com.gom.timeshare.schedule.Schedule;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NamedEntityGraph(name="Member.schedule",attributeNodes = {@NamedAttributeNode("scheduleList")})
@Entity
@DynamicInsert
@DynamicUpdate
@Getter
public class Member {

    @Id
    private String userId;
    private String password;
    private String nickName;
    private String gender;
    private String email;
    private String thumbnailUrl;
    private String socialLoginId;
    private LocalDateTime regDate;
    private boolean isLeave;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Schedule> scheduleList = new ArrayList<>();

    public static Member createMember(MemberForm form){
        Member member = new Member();
        formToMember(member, form);
        return member;
    }

    public static void modifyMember(Member member, MemberForm form){
        formToMember(member, form);
    }

    private static void formToMember(Member member, MemberForm form) {
        member.userId = form.getUserId();
        member.password = form.getPassword();
        member.gender = form.getGender();
        member.nickName = form.getNickName();
        member.email = form.getEmail();
        member.socialLoginId = form.getSocialLoginId();
        member.thumbnailUrl = form.getThumbnailUrl();
        member.isLeave = false;
        member.regDate = LocalDateTime.now();
    }

    public MemberForm getMemberForm(){
        MemberForm form = new MemberForm();
        form.setUserId(this.userId);
        form.setPassword(this.password);
        form.setNickName(this.nickName);
        form.setGender(this.gender);
        form.setEmail(this.email);
        form.setThumbnailUrl(this.thumbnailUrl);
        form.setSocialLoginId(this.socialLoginId);
        form.setLeave(this.isLeave);
        form.setRegDate(this.regDate);
        return form;
    }













}


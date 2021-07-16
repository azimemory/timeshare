package com.gom.timeshare.schedule;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@DynamicInsert
@DynamicUpdate
public class Schedule {

    @Id
    @GeneratedValue
    private long scIdx;
    private String title;
    private String contents;
    private Date begin;
    private Date end;
    @Column(columnDefinition = "date default sysdate")
    private Date regDate;

    public long getScIdx() {
        return scIdx;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }

    public Date getRegDate() {
        return regDate;
    }
}

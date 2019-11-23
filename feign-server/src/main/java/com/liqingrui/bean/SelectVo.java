package com.liqingrui.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SelectVo {
    private String htId;
    private String skr;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startHk;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endHk;
    private String kuan;  // 余款 || 回款
    private Integer startMoney;
    private Integer endMoney;

    public String getHtId() {
        return htId;
    }

    public void setHtId(String htId) {
        this.htId = htId;
    }

    public String getSkr() {
        return skr;
    }

    public void setTypeId(String skr) {
        this.skr = skr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getStartHk() {
        return startHk;
    }

    public void setStartHk(Date startHk) {
        this.startHk = startHk;
    }

    public Date getEndHk() {
        return endHk;
    }

    public void setEndHk(Date endHk) {
        this.endHk = endHk;
    }

    public String getKuan() {
        return kuan;
    }

    public void setKuan(String kuan) {
        this.kuan = kuan;
    }

    public Integer getStartMoney() {
        return startMoney;
    }

    public void setStartMoney(Integer startMoney) {
        this.startMoney = startMoney;
    }

    public Integer getEndMoney() {
        return endMoney;
    }

    public void setEndMoney(Integer endMoney) {
        this.endMoney = endMoney;
    }

    @Override
    public String toString() {
        return "SelectVo{" +
                "htId='" + htId + '\'' +
                ", skr=" + skr +
                ", content='" + content + '\'' +
                ", startHk=" + startHk +
                ", endHk=" + endHk +
                ", kuan='" + kuan + '\'' +
                ", startMoney=" + startMoney +
                ", endMoney=" + endMoney +
                '}';
    }
}

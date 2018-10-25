package com.carryit.base.besttmwuu.entity;

import java.io.Serializable;
/*
*发布活动
 */
public class Activity implements Serializable{

    private Integer uid; //用户id
    private Integer bid; //圈子id
    private String title;//活动标题
    private String startTime;//活动开始时间，13位毫秒值
    private String endTime;//活动结束时间，13位毫秒值
    private String cerateTime;//创建时间，13位毫秒值
    private String address;//活动详细地址
    private float cost; //费用(免费为0.00)
    private int peopleNumber;//人数
    private String level;//参加人员等级限制
    private String detail;//活动介绍
    private String images;
    private String board;//圈子
    private String levelname;//等级名称
    private int joinNumber; //参加人数

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCerateTime() {
        return cerateTime;
    }

    public void setCerateTime(String cerateTime) {
        this.cerateTime = cerateTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public int getJoinNumber() {
        return joinNumber;
    }

    public void setJoinNumber(int joinNumber) {
        this.joinNumber = joinNumber;
    }
}
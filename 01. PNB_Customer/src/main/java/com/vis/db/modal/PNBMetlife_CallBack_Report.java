package com.vis.db.modal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "PNBMetlife_CallBack_Report")
public class PNBMetlife_CallBack_Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    private String ANI;
    private String UCID;
    private String Session_ID;
    private String DNIS;
    private String Call_Back;
    private String CallBack_AltNum;
    @Column(name = "Start_Time")
    private Date startTime;
    @Column(name = "End_Time")
    private Date endTime;

    private String Call_Duration;

    public PNBMetlife_CallBack_Report() {
        super();
    }

    public PNBMetlife_CallBack_Report(int iD, String aNI, String uCID, String session_ID, String dNIS, String call_Back,
            String callBack_AltNum, Date startTime, Date endTime, String call_Duration) {
        super();
        ID = iD;
        ANI = aNI;
        UCID = uCID;
        Session_ID = session_ID;
        DNIS = dNIS;
        Call_Back = call_Back;
        CallBack_AltNum = callBack_AltNum;
        this.startTime = startTime;
        this.endTime = endTime;
        Call_Duration = call_Duration;
    }

    // Getters and setters for the variables

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getANI() {
        return ANI;
    }

    public void setANI(String aNI) {
        ANI = aNI;
    }

    public String getUCID() {
        return UCID;
    }

    public void setUCID(String uCID) {
        UCID = uCID;
    }

    public String getSession_ID() {
        return Session_ID;
    }

    public void setSession_ID(String session_ID) {
        Session_ID = session_ID;
    }

    public String getDNIS() {
        return DNIS;
    }

    public void setDNIS(String dNIS) {
        DNIS = dNIS;
    }

    public String getCall_Back() {
        return Call_Back;
    }

    public void setCall_Back(String call_Back) {
        Call_Back = call_Back;
    }

    public String getCallBack_AltNum() {
        return CallBack_AltNum;
    }

    public void setCallBack_AltNum(String callBack_AltNum) {
        CallBack_AltNum = callBack_AltNum;
    }

    public String getCall_Duration() {
        return Call_Duration;
    }

    public void setCall_Duration(String call_Duration) {
        Call_Duration = call_Duration;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            this.startTime = dateFormat.parse(startTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            this.endTime = dateFormat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @PrePersist
    public void onPrePersist() {
        this.startTime = new Date();
        this.endTime = new Date();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.endTime = new Date();
    }

    @Override
    public String toString() {
        return "PNBMetlife_CallBack_Report [ID=" + ID + ", ANI=" + ANI + ", UCID=" + UCID + ", Session_ID=" + Session_ID
                + ", DNIS=" + DNIS + ", Call_Back=" + Call_Back + ", CallBack_AltNum=" + CallBack_AltNum
                + ", startTime=" + startTime + ", endTime=" + endTime + ", Call_Duration=" + Call_Duration + "]";
    }
}

package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Journey {

    @PrimaryKey (autoGenerate = true)
    private int journeyID;
    private int trainNo;
    private String origin;
    private String destination;
    private String day;
    private String time;
    private boolean status;

    public Journey(int trainNo, String origin, String destination, String day, String time, boolean status) {
        this.trainNo = trainNo;
        this.origin = origin;
        this.destination = destination;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Journey{" +
                "journeyID=" + journeyID +
                ", trainNo=" + trainNo +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", day=" + day +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}

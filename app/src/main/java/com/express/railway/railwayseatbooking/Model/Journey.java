package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Time;
import java.time.DayOfWeek;

@Entity
public class Journey {

    @PrimaryKey (autoGenerate = true)
    private int journeyID;
    private int trainNo;
    private String origin;
    private String destination;
    private DayOfWeek day;
    private Time time;
    private boolean status;

    public Journey(int journeyID, int trainNo, String origin, String destination, DayOfWeek day, Time time, boolean status) {
        this.journeyID = journeyID;
        this.trainNo = trainNo;
        this.origin = origin;
        this.destination = destination;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    public Journey(){

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

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
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

package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Train {

    @PrimaryKey(autoGenerate = true)
    private int trainNo;
    private String trainName;
    private String isBookingAvailable;

    public Train(int trainNo, String trainName, String isBookingAvailable) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.isBookingAvailable = isBookingAvailable;
    }

    public Train(){

    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getIsBookingAvailable() {
        return isBookingAvailable;
    }

    public void setIsBookingAvailable(String isBookingAvailable) {
        this.isBookingAvailable = isBookingAvailable;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNo=" + trainNo +
                ", trainName='" + trainName + '\'' +
                ", isBookingAvailable='" + isBookingAvailable + '\'' +
                '}';
    }
}

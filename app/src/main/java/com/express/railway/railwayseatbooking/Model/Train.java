package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Train {

    @PrimaryKey(autoGenerate = true)
    private Integer trainNo;
    private String trainName;
    private boolean isBookingAvailable;

    public Train(Integer trainNo, String trainName, boolean isBookingAvailable) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.isBookingAvailable = isBookingAvailable;
    }

    public Integer getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(Integer trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public boolean getIsBookingAvailable() {
        return isBookingAvailable;
    }

    public void setIsBookingAvailable(boolean isBookingAvailable) {
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

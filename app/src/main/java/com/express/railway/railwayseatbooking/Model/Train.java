package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Random;

@Entity
public class Train {

    @PrimaryKey(autoGenerate = true)
    private int trainNo = new Random().nextInt(10000)+1;
    private String trainName;
    private boolean isBookingAvailable;

    public Train(String trainName, boolean isBookingAvailable) {
        this.trainName = trainName;
        this.isBookingAvailable = isBookingAvailable;
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

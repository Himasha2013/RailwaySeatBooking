package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Seat {

    @PrimaryKey(autoGenerate = true)
    private int seatNo;
    private int trainNo;
    private int noOfFirstClassSeats;
    private int noOfSecondClassSeats;
    private int firstClassPrice;
    private int secondClassPrice;

    public Seat(int seatNo, int trainNo, int noOfFirstClassSeats, int noOfSecondClassSeats, int firstClassPrice, int secondClassPrice) {
        this.seatNo = seatNo;
        this.trainNo = trainNo;
        this.noOfFirstClassSeats = noOfFirstClassSeats;
        this.noOfSecondClassSeats = noOfSecondClassSeats;
        this.firstClassPrice = firstClassPrice;
        this.secondClassPrice = secondClassPrice;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public int getNoOfFirstClassSeats() {
        return noOfFirstClassSeats;
    }

    public void setNoOfFirstClassSeats(int noOfFirstClassSeats) {
        this.noOfFirstClassSeats = noOfFirstClassSeats;
    }

    public int getNoOfSecondClassSeats() {
        return noOfSecondClassSeats;
    }

    public void setNoOfSecondClassSeats(int noOfSecondClassSeats) {
        this.noOfSecondClassSeats = noOfSecondClassSeats;
    }

    public int getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(int firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public int getSecondClassPrice() {
        return secondClassPrice;
    }

    public void setSecondClassPrice(int secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNo=" + seatNo +
                ", trainNo=" + trainNo +
                ", noOfFirstClassSeats=" + noOfFirstClassSeats +
                ", noOfSecondClassSeats=" + noOfSecondClassSeats +
                ", firstClassPrice=" + firstClassPrice +
                ", secondClassPrice=" + secondClassPrice +
                '}';
    }
}

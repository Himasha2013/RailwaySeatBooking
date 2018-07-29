package com.express.railway.railwayseatbooking.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Random;

@Entity
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    private int reservationID = new Random().nextInt(10000)+1;
    private int journeyID;
    private String date;
    private String passengerName;
    private int noOfFirstClassSeats;
    private int noOfSecondClassSeats;
    private int totalBill;

    public Reservation(int journeyID, String date, String passengerName, int noOfFirstClassSeats, int noOfSecondClassSeats, int totalBill) {
        this.journeyID = journeyID;
        this.date = date;
        this.passengerName = passengerName;
        this.noOfFirstClassSeats = noOfFirstClassSeats;
        this.noOfSecondClassSeats = noOfSecondClassSeats;
        this.totalBill = totalBill;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
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

    public int getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(int totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationID=" + reservationID +
                ", journeyID=" + journeyID +
                ", date=" + date +
                ", passengerName='" + passengerName + '\'' +
                ", noOfFirstClassSeats=" + noOfFirstClassSeats +
                ", noOfSecondClassSeats=" + noOfSecondClassSeats +
                ", totalBill=" + totalBill +
                '}';
    }
}

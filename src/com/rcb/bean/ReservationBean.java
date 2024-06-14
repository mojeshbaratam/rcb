package com.rcb.bean;

import java.util.Date;

public class ReservationBean {
    private String reservationID;
    private String scheduleID;
    private String userID;
    private int noOfSeats;
    private Date bookingDate;
    private Date journeyDate;
    private float totalFare;
    private String bookingStatus;
    public String getReservationID() {
        return reservationID;
    }
    public void setReservationID(String reservationID) {
        this.reservationID = reservationID;
    }
    public String getScheduleID() {
        return scheduleID;
    }
    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public int getNoOfSeats() {
        return noOfSeats;
    }
    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
    
    public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date string) {
		this.bookingDate = string;
	}
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public float getTotalFare() {
        return totalFare;
    }
    public void setTotalFare(float totalFare) {
        this.totalFare = totalFare;
    }
    public String getBookingStatus() {
        return bookingStatus;
    }
    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
    @Override
    public String toString() {
        return "\nreservationID=" + reservationID + ", scheduleID=" + scheduleID + ", userID=" + userID
                + ", bookingDate=" + bookingDate + ", journeyDate=" + journeyDate + ", noOfSeats=" + noOfSeats
                + ", totalFare=" + totalFare + ", bookingStatus=" + bookingStatus;
    }
    
}

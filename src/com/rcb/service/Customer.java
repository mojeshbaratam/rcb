package com.rcb.service;

import java.util.ArrayList;

import com.rcb.bean.CredentialsBean;
import com.rcb.bean.ProfileBean;
import com.rcb.bean.ReservationBean;
import com.rcb.bean.ScheduleBean;

public interface Customer 
{
	ArrayList<ScheduleBean> viewScheduleByRoute();

	String reserveTicket(ReservationBean rsb);

	String cancelTicket(String userID, String reservationID);

	String login(CredentialsBean credentialsBean);

	String register(ProfileBean profileBean);

	ReservationBean viewBookingDetails(String reservationID);

}

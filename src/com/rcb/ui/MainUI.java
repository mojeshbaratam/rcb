package com.rcb.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.rcb.bean.CredentialsBean;
import com.rcb.bean.PassengerBean;
import com.rcb.bean.ProfileBean;
import com.rcb.bean.RouteBean;
import com.rcb.bean.ScheduleBean;
import com.rcb.bean.ShipBean;
import com.rcb.bean.ReservationBean;
import com.rcb.dao.AdministratorDao;
import com.rcb.dao.CustomerDao;

public class MainUI {
	public static ShipBean sb;
	public static RouteBean rb;
	public static ScheduleBean scb;
	public static PassengerBean pb;
	public static ReservationBean rsb;
	public static CredentialsBean cb;
	public static ProfileBean prb;

	public static ShipBean addShip() {
		String shipName = JOptionPane.showInputDialog("Enter Ship Name");
		int seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Seating Capacity"));
		int reservationCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Reservation Capacity"));
		String shipId = shipName.substring(0, 2) + Math.round(Math.random() * 10000);
		sb = new ShipBean();

		sb.setShipId(shipId);
		sb.setShipName(shipName);
		sb.setSeatingCapacity(seatingCapacity);
		sb.setReservationCapacity(reservationCapacity);
		return sb;
	}

	public static RouteBean addRoute() {
		String source = JOptionPane.showInputDialog("Enter source");
		String destination = JOptionPane.showInputDialog("Enter destination");
		String travelDuration = JOptionPane.showInputDialog("Enter Travel Duration");
		double fare = Double.parseDouble(JOptionPane.showInputDialog("Enter fare"));
		String routeId = source.substring(0, 2) + destination.substring(0, 2) + Math.round(Math.random() * 10000);
		rb = new RouteBean();
		rb.setRouteID(routeId);
		rb.setSource(source);
		rb.setDestination(destination);
		rb.setTravelDuration(travelDuration);
		rb.setFare(fare);
		return rb;
	}

	public static ScheduleBean addSchedule() {
		String shipID = JOptionPane.showInputDialog("Enter ship ID");
		String routeID = JOptionPane.showInputDialog("Enter route ID");
		String start = JOptionPane.showInputDialog("Enter start date");
		String scheduleId = routeID.substring(0, 4) + Math.round(Math.random() * 10000);
		scb = new ScheduleBean();
		scb.setScheduleID(scheduleId);
		scb.setShipID(shipID);
		scb.setRouteID(routeID);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate = null;
		try {
			startDate = sdf1.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		scb.setStartDate(startDate);
		return scb;
	}

	public static ShipBean updateShip() {
		String shipId = JOptionPane.showInputDialog("Enter Ship ID to Modify");
		String shipName = JOptionPane.showInputDialog("Enter Ship Name");
		int seatingCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Seating Capacity"));
		int reservationCapacity = Integer.parseInt(JOptionPane.showInputDialog("Enter Reservation Capacity"));
		sb = new ShipBean();

		sb.setShipId(shipId);
		sb.setShipName(shipName);
		sb.setSeatingCapacity(seatingCapacity);
		sb.setReservationCapacity(reservationCapacity);
		return sb;
	}

	public static RouteBean updateRoute() {
		String routeId = JOptionPane.showInputDialog("Enter RouteId to modify");
		String source = JOptionPane.showInputDialog("Enter source");
		String destination = JOptionPane.showInputDialog("Enter destination");
		String travelDuration = JOptionPane.showInputDialog("Enter Travel Duration");
		double fare = Double.parseDouble(JOptionPane.showInputDialog("Enter fare"));
		rb = new RouteBean();
		rb.setRouteID(routeId);
		rb.setSource(source);
		rb.setDestination(destination);
		rb.setTravelDuration(travelDuration);
		rb.setFare(fare);
		return rb;
	}

	public static ScheduleBean updateSchedule() {
		String scheduleId = JOptionPane.showInputDialog("Enter Schedule ID to modify");
		String shipID = JOptionPane.showInputDialog("Enter ship ID");
		String routeID = JOptionPane.showInputDialog("Enter route ID");
		String start = JOptionPane.showInputDialog("Enter start date");
		scb = new ScheduleBean();
		scb.setScheduleID(scheduleId);
		scb.setShipID(shipID);
		scb.setRouteID(routeID);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
		Date startDate = null;
		try {
			startDate = sdf1.parse(start);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		scb.setStartDate(startDate);
		return scb;
	}

	public static String deleteShip() {
		String shipID = JOptionPane.showInputDialog("Enter Ship ID");
		return shipID;
	}

	public static String deleteRoute() {
		String routeID = JOptionPane.showInputDialog("Enter Route ID");
		return routeID;
	}

	public static String deleteSchedule() {
		String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID");
		return scheduleID;
	}

	public static String viewShipById() {
		String shipID = JOptionPane.showInputDialog("Enter Ship ID");
		return shipID;
	}

	public static String viewRouteById() {
		String routeID = JOptionPane.showInputDialog("Enter Route ID");
		return routeID;
	}

	public static String viewScheduleById() {
		String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID");
		return scheduleID;
	}

	public static String viewPassengersByShip() {
		String ShipID = JOptionPane.showInputDialog("Enter Ship ID to view passengers");
		return ShipID;
	}

	public static ReservationBean reserveTicket() {
		String scheduleID = JOptionPane.showInputDialog("Enter Schedule ID");
		String userID = JOptionPane.showInputDialog("Enter User ID");
		int noOfSeats = Integer.parseInt(JOptionPane.showInputDialog("Enter No of Seats"));
		Date bookingDate = new Date();
		Date journeyDate = new Date();
		String bookingStatus = "Confirmed";
		String reservationID = scheduleID.substring(0, 4) + Math.round(Math.random() * 10000);
		rsb = new ReservationBean();
		rsb.setReservationID(reservationID);
		rsb.setScheduleID(scheduleID);
		rsb.setUserID(userID);
		rsb.setNoOfSeats(noOfSeats);
		rsb.setBookingDate(bookingDate);
		rsb.setJourneyDate(journeyDate);
		rsb.setBookingStatus(bookingStatus);

		return rsb;
	}

	public static CredentialsBean authenticate() {
		String userid = JOptionPane.showInputDialog("Enter User ID:");
		String userPassword = JOptionPane.showInputDialog("Enter User Password:");
		cb = new CredentialsBean();
		cb.setUserID(userid);
		cb.setPassword(userPassword);
		return cb;
	}

	public static ProfileBean userDetails() {
		String name = JOptionPane.showInputDialog("enter Name:");
		String dob = JOptionPane.showInputDialog("enter DateOfBirth as (yyyy/MM/dd) :");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		Date dateOfBirth = null;
		try {
			dateOfBirth = sdf.parse(dob);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String gender = JOptionPane.showInputDialog("enter Gender:");
		while (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
			JOptionPane.showMessageDialog(null, "Gender must be either Male or Female");
			gender = JOptionPane.showInputDialog("enter Gender:");
		}
		String city = JOptionPane.showInputDialog("enter City :");
		String state = JOptionPane.showInputDialog("enter State :");
		String pinCode = JOptionPane.showInputDialog("enter PinCode: ");
		while (pinCode.length() != 6) {
			JOptionPane.showMessageDialog(null, "Pincode must be 6 digits");
			pinCode = JOptionPane.showInputDialog("enter PinCode: ");
		}
		String mobileNo = JOptionPane.showInputDialog("enter MobileNo :");
		while (mobileNo.length() != 10) {
			JOptionPane.showMessageDialog(null, "Mobile Number must be 10 digits");
			mobileNo = JOptionPane.showInputDialog("enter MobileNo: ");
		}
		String emailId = JOptionPane.showInputDialog("enter EmailId : ");
		while (!(emailId.contains("@") && emailId.contains(".com"))) {
			JOptionPane.showMessageDialog(null, "Invalid Email Try Again");
			emailId = JOptionPane.showInputDialog("enter EmailId : ");
		}

		String pass1 = JOptionPane.showInputDialog("Create Password");
		String pass2 = JOptionPane.showInputDialog("Re-enter Password");
		while (!(pass1.equals(pass2))) {
			JOptionPane.showMessageDialog(null, "Password Mismatch... Try Again");
			pass1 = JOptionPane.showInputDialog("Create Password");
			pass2 = JOptionPane.showInputDialog("Re-enter Password");
		}
		String userID = name.substring(0, 2) + Math.round(Math.random() * 10000);

		prb = new ProfileBean();
		prb.setUserID(userID);
		prb.setName(name);
		prb.setDob(dateOfBirth);
		prb.setGender(gender);
		prb.setCity(city);
		prb.setState(state);
		prb.setPincode(pinCode);
		prb.setMobile(mobileNo);
		prb.setEmail(emailId);
		prb.setPass(pass1);
		prb.setPass(pass2);
		return prb;
	}

	public static void main(String[] args) {
		AdministratorDao adao = new AdministratorDao();
		CustomerDao cdao = new CustomerDao();
		String uType = JOptionPane.showInputDialog("Enter User Type: 'ADMIN' or 'USER'");
		if (uType.equalsIgnoreCase("Admin"))
			while (uType.equalsIgnoreCase("Admin")) {
				{
					String uname = JOptionPane.showInputDialog("Enter username");
					String pass = JOptionPane.showInputDialog("Enter Password");
					if ((uname.equals("AD-001")) && (pass.equals("AD-001"))) {
						addShip();
						JOptionPane.showMessageDialog(null, adao.addShip(sb));
					} else if (uname.equals("AD-002") && (pass.equals("AD-002"))) {
						JOptionPane.showMessageDialog(null, adao.removeShip(deleteShip()));
					}

					else if ((uname.equals("AD-003")) && (pass.equals("AD-003"))) {
						ShipBean s1 = adao.viewShip(viewShipById());
						JOptionPane.showMessageDialog(null,
								s1.getShipName() + " " + s1.getSeatingCapacity() + " " + s1.getReservationCapacity());
						System.out.println("Ships Details");
						System.out.println(adao.viewAllShip());
					} else if (uname.equals("AD-004") && (pass.equals("AD-004"))) {
						updateShip();
						JOptionPane.showMessageDialog(null, adao.modifyShip(sb));
					} else if (uname.equals("AD-005") && (pass.equals("AD-005"))) {
						addRoute();
						JOptionPane.showMessageDialog(null, adao.addRoute(rb));
					} else if (uname.equals("AD-006") && (pass.equals("AD-006"))) {
						JOptionPane.showMessageDialog(null, adao.removeRoute(deleteRoute()));
					} else if ((uname.equals("AD-007")) && (pass.equals("AD-007"))) {
						RouteBean s1 = adao.viewRoute(viewRouteById());
						JOptionPane.showMessageDialog(null, s1.getSource() + " " + s1.getDestination() + " "
								+ s1.getTravelDuration() + " " + s1.getFare());
						System.out.println("Routes Details");
						System.out.println(adao.viewAllRoutes());
					} else if (uname.equals("AD-008") && (pass.equals("AD-008"))) {
						updateRoute();
						JOptionPane.showMessageDialog(null, adao.modifyRoute(rb));
					} else if (uname.equals("AD-009") && (pass.equals("AD-009"))) {
						addSchedule();
						JOptionPane.showMessageDialog(null, adao.addSchedule(scb));
					} else if (uname.equals("AD-010") && (pass.equals("AD-010"))) {
						JOptionPane.showMessageDialog(null, adao.removeSchedule(deleteSchedule()));
					} else if ((uname.equals("AD-011")) && (pass.equals("AD-011"))) {
						ScheduleBean s1 = adao.viewSchedule(viewScheduleById());
						JOptionPane.showMessageDialog(null,
								s1.getShipID() + " " + s1.getRouteID() + " " + s1.getStartDate());
						System.out.println("Schedules Details");
						System.out.println(adao.viewAllSchedules());
					} else if (uname.equals("AD-012") && (pass.equals("AD-012"))) {
						updateSchedule();
						JOptionPane.showMessageDialog(null, adao.modifySchedule(scb));
					} else if ((uname.equals("AD-013")) && (pass.equals("AD-013"))) {
						JOptionPane.showMessageDialog(null, adao.viewPassengersByShip(viewPassengersByShip()));
					} else {
						JOptionPane.showMessageDialog(null, "Invalid UserID or Password");
					}
				}
				String i = JOptionPane.showInputDialog("Do you want to Continue\n");
				if (i.equalsIgnoreCase("NO"))
					break;
			}
		else if (uType.equalsIgnoreCase("User")) {
			JOptionPane.showMessageDialog(null, "Press 1 to Login\nPress 2 to Register");
			int userChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter Your Choice"));
			switch (userChoice) {
			case 1:
				authenticate();
				String ok = cdao.login(cb);
				JOptionPane.showMessageDialog(null, ok);
				if (ok.equals("WELCOME")) {
					int choice = Integer.parseInt(JOptionPane.showInputDialog(
							"Enter->\n1 to View Schedule by route\n2 to Reserve Ticket\n3 to Cnacel Ticket\n4 to VIew Booking Details"));
					switch (choice) {
					case 1:
						ArrayList<ScheduleBean> al = cdao.viewScheduleByRoute();
						JOptionPane.showMessageDialog(null, al);
						if (al.size() > 0) {
							String res = JOptionPane.showInputDialog("Press 1 to reserve a ticket");
							if (res.equals("1")) {
								reserveTicket();
								JOptionPane.showMessageDialog(null, cdao.reserveTicket(rsb));
							}
						}
						break;
					case 2:
						reserveTicket();
						JOptionPane.showMessageDialog(null, cdao.reserveTicket(rsb));
						break;
					case 3:
						String userID = JOptionPane.showInputDialog("Enter UserID");
						String reservationID = JOptionPane.showInputDialog("Enter Reservation ID");

						JOptionPane.showMessageDialog(null, cdao.cancelTicket(userID, reservationID));
						break;
					case 4:
						String reserveID = JOptionPane.showInputDialog("Enter Reservation ID");

						JOptionPane.showMessageDialog(null, cdao.viewBookingDetails(reserveID));
						break;
					default:
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}
				}
				break;
			case 2:
				userDetails();
				JOptionPane.showMessageDialog(null, cdao.register(prb));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Invalid Choice...");
			}
		}
	}
	
}
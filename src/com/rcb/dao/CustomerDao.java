package com.rcb.dao;

import com.rcb.bean.CredentialsBean;
import com.rcb.bean.ProfileBean;
import com.rcb.bean.ReservationBean;
import com.rcb.bean.ScheduleBean;
import com.rcb.service.Customer;
import com.rcb.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CustomerDao implements Customer
{
	public Connection con=DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
    public PreparedStatement ps;
    public ResultSet rs;
    @Override
	public ArrayList<ScheduleBean> viewScheduleByRoute() 
	{
        ArrayList<ScheduleBean> schedules=new ArrayList<ScheduleBean>();
        
        String source=JOptionPane.showInputDialog("Enter Source");
    	String destination=JOptionPane.showInputDialog("Enter Destination");
    	String date1=JOptionPane.showInputDialog("Enter Date");
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy/MM/dd");
        Date date=null;
       try {
           date = sdf1.parse(date1);
       } catch (ParseException e) {
           e.printStackTrace();
       }        
        try
        {
             ps=con.prepareStatement("SELECT S.* FROM SCHEDULE S INNER JOIN ROUTE R ON S.ROUTEID=R.ROUTEID WHERE SOURCE=? AND DESTINATION=? AND STARTDATE=?");
             ps.setString(1, source.toString());
             ps.setString(2, destination.toString());
             ps.setDate(3, new java.sql.Date(date.getTime()));
             rs=ps.executeQuery();
                
                while(rs.next())
                {
                    ScheduleBean sb = new ScheduleBean();
                   
                    sb.setScheduleID(rs.getString(1));
                    sb.setShipID(rs.getString(2));
                    sb.setRouteID(rs.getString(3));
                    sb.setStartDate(rs.getDate(4));
                    schedules.add(sb);
                }
            }
            catch(Exception sql)
            {
                sql.printStackTrace();
            }
            return schedules;
        }
    
    @Override
	public String reserveTicket(ReservationBean rsb) 
	{
		try
		{
			ps=con.prepareStatement("select fare,startdate from route r join schedule s on r.routeid=s.routeid where scheduleid=?");
			ps.setString(1, rsb.getScheduleID());
			rs=ps.executeQuery();
		    PreparedStatement ps2 =con.prepareStatement("Insert into reservation values(?,?,?,?,?,?,?,?)");
			ps2.setString(1, rsb.getReservationID());
			ps2.setString(2, rsb.getScheduleID());
			ps2.setString(3, rsb.getUserID());
			ps2.setDate(4, new java.sql.Date(rsb.getBookingDate().getTime()));
			ps2.setInt(6, rsb.getNoOfSeats());
			while(rs.next())
			{
			ps2.setFloat(7,rsb.getNoOfSeats()*rs.getFloat(1));
			ps2.setDate(5, new java.sql.Date(rs.getDate(2).getTime()));
			}
			ps2.setString(8, rsb.getBookingStatus());
			int i=ps2.executeUpdate();
	        if(i==1)
	        {
	            return "SUCCESS\nYour Reservation ID is:"+rsb.getReservationID();
	        }
		}
		catch(Exception sql)
        {
            sql.printStackTrace();
            return "FAIL";
        }
		return "ERROR";
	}

    @Override
	public String cancelTicket(String userID, String reservationID) 
	{
		try
		{
			ps=con.prepareStatement("Delete from reservation where userid=? AND reservationId=?");
			ps.setString(1, userID);
			ps.setString(2, reservationID);
			int i=ps.executeUpdate();
			if(i==1)
				return "SUCCESS";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "FAIL";
		}
		return "ERROR";
	}
    @Override
	public ReservationBean viewBookingDetails(String reservationID) 
	{
		ReservationBean rb=new ReservationBean();
		try
		{
			ps=con.prepareStatement("Select * from reservation where reservationID=?");
			ps.setString(1, reservationID);
			rs=ps.executeQuery();
			while(rs.next())
			{
				rb.setReservationID(rs.getString(1));
				rb.setScheduleID(rs.getString(2));
				rb.setUserID(rs.getString(3));
				rb.setBookingDate(rs.getDate(4));
				rb.setJourneyDate(rs.getDate(5));
				rb.setNoOfSeats(rs.getInt(6));
				rb.setTotalFare(rs.getFloat(7));
				rb.setBookingStatus(rs.getString(8));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rb;
	}
	
	@Override
	public String login(CredentialsBean credentialsBean) 
	{
		String str = "";
		try {
		ps = con.prepareStatement("select userid, password from user_credentials where Userid=?");
		ps.setString(1, credentialsBean.getUserID()); 
		//ps.setString (2, credentialsBean.getPassword());
		//ps.setString (3, credentialsBean.getUsertype());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) 
		{
			if(credentialsBean.getUserID().equals(rs.getString("userid"))) 
			{
				if (credentialsBean.getPassword().equals(rs.getString("password")))
					str = "WELCOME";
				else
					str = "Enter Correct Password";
			}
		}
		else
			str ="user id not found";
		} 
		catch (Exception sql) 
		{
			sql.printStackTrace();
			str = "FAIL";
			System.out.println(str);
		}
		return str;
	}
	
	@Override
	public String register (ProfileBean pb) 
	{
		String str = "";
		try 
		{		
			PreparedStatement ps1 = con.prepareStatement("insert into user_credentials values(?,?,?)");
			ps1.setString(1, pb.getUserID());		
			ps1.setString(2, pb.getPass());		
			ps1.setString(3, "USER");		
			ps1.executeUpdate();	
			ps =con.prepareStatement("insert into user_profile values(?,?,?,?,?,?,?,?,?,?)");		
			ps.setString(1, pb.getUserID());		
			ps.setString(2, pb.getName());		
			ps.setDate(3, new java.sql.Date(pb.getDob().getTime()));		
			ps.setString(4, pb.getGender());		
			ps.setString(5, pb.getCity());		
			ps.setString(6, pb.getState());		
			ps.setString(7, pb.getPincode());		
			ps.setString(8, pb.getMobile());		
			ps.setString(9, pb.getEmail());		
			ps.setString(10, pb.getPass());		
			int i=ps.executeUpdate();
			if (i == 1)		
				str = "SUCCESS\nUserID: "+pb.getUserID()+"\nPassword: "+pb.getPass();
		}
		catch (Exception sql) 
		{
			sql.printStackTrace();
			str = "FAIL";
			System.out.println(str);
		}
		return str;
	}
}
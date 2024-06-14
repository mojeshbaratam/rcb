package com.rcb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.rcb.bean.PassengerBean;
import com.rcb.bean.RouteBean;
import com.rcb.bean.ScheduleBean;
import com.rcb.bean.ShipBean;
import com.rcb.service.Administrator;
import com.rcb.util.DBUtil;

public class AdministratorDao implements Administrator
{
	public Connection con=DBUtil.getDBConnection("com.mysql.cj.jdbc.Driver");
    public PreparedStatement ps;
    public ResultSet rs;
    @Override
	public Object addShip(ShipBean sb) 
    {
    	String str="";
        try
        {
        //ps=con.prepareStatement("insert into ship values(?,?,?,?)");
        ps.setString(1, sb.getShipId());
        ps.setString(2, sb.getShipName());
        ps.setInt(3, sb.getSeatingCapacity());
        ps.setInt(4, sb.getReservationCapacity());
        int i=ps.executeUpdate();
        if(i==1)
        {
            return str="SUCCESS";
        }
        
        }catch(Exception sql)
        {
            str="FAIL";
            System.out.println(str); 
            sql.printStackTrace();
        }
            return "ERROR";
            
	}
    @Override
	public Object removeShip(String shipId) 
	{
		int i=0;
	    try
	    {
	    ps=con.prepareStatement("delete from ship where ShipId=?");
	    ps.setString(1, shipId);
	    i=ps.executeUpdate();
	    }
	    catch(Exception sql)
	    {
	        System.out.println(sql);
	    }
	    
	    return i;
	}
    @Override
	public ShipBean viewShip(String shipId) {
		ShipBean sb1=new ShipBean();
	    try
	    {
	        ps=con.prepareStatement("select * from ship where shipId=?");
	        ps.setString(1, shipId);
	        rs=ps.executeQuery();
	        if(rs.next())
	        {
	            sb1.setShipId(rs.getString("ShipId"));
	            sb1.setShipName(rs.getString(2));
	            sb1.setSeatingCapacity(rs.getInt(3));
	            sb1.setReservationCapacity(rs.getInt(4));
	        }
	    }
	    catch(Exception sql)
	    {
	        
	    }
	    return sb1;
	}
    @Override
	public Object modifyShip(ShipBean sb) {
		try
	    {
	    ps=con.prepareStatement("update ship set shipname=?,seatingcapacity=?,reservationcapacity=? where shipid=?");
	    ps.setString(1, sb.getShipName());
	    ps.setInt(2, sb.getSeatingCapacity());
	    ps.setInt(3, sb.getReservationCapacity());
	    ps.setString(4, sb.getShipId());
	    int i=ps.executeUpdate();
	    if(i>0)
	    {
	        return true;
	    }
	    }
	    catch(Exception sql)
	    {
	        sql.printStackTrace();
	        return false;
	    }
	    return false;
	}
    @Override
	public Object addRoute(RouteBean rb) 
	{
		String str="";
        try
        {
        ps=con.prepareStatement("insert into route values(?,?,?,?,?)");
        ps.setString(1, rb.getRouteID());
        ps.setString(2, rb.getSource());
        ps.setString(3, rb.getDestination());
        ps.setString(4, rb.getTravelDuration());
        ps.setDouble(5, rb.getFare());
        
        int i=ps.executeUpdate();
        if(i==1)
        {
            return str="SUCCESS";
        }  
        }
        catch(Exception sql)
        {
            sql.printStackTrace();
            str="FAIL";
        
        System.out.println(str);    
        }
        
            return "ERROR";
	}
    @Override
	public Object removeRoute(String routeId) 
	{
		int i=0;
	    try
	    {
	    ps=con.prepareStatement("delete from route where RouteId=?");
	    ps.setString(1, routeId);
	    i=ps.executeUpdate();
	    }
	    catch(Exception sql)
	    {
	        System.out.println(sql);
	    }
	    return i;
	}
    @Override
	public RouteBean viewRoute(String routeId) 
	{
		RouteBean rb=new RouteBean();
	       try
	       {
	           ps=con.prepareStatement("select * from route where RouteId=?");
	           ps.setString(1, routeId);
	           rs=ps.executeQuery();
	           if(rs.next())
	           {
	               rb.setRouteID(rs.getString(1));
	               rb.setSource(rs.getString(2));
	               rb.setDestination(rs.getString(3));
	               rb.setTravelDuration(rs.getString(4));
	               rb.setFare(rs.getDouble(5));
	           }
	       }
	       catch(Exception sql)
	       {
	           System.out.println(sql);
	       }
	       return rb;
	}
	@Override
	public Object modifyRoute(RouteBean rb) {
		try
	    {
	    ps=con.prepareStatement("update route set source=?,destination=?,travelDuration=?,fare=? where RouteId=?");
	    ps.setString(1, rb.getSource());
	    ps.setString(2, rb.getDestination());
	    ps.setString(3, rb.getTravelDuration());
	    ps.setDouble(4, rb.getFare());
	    ps.setString(5, rb.getRouteID());
	   
	    int i=ps.executeUpdate();
	    if(i==1)
	    {
	        return true;
	    }
	    }
	    catch(Exception sql)
	    {
	        
	        return false;
	    }
	    return false;
	}
	@Override
	public Object addSchedule(ScheduleBean sb) 
	{
		String str="";
        try
        {
        ps=con.prepareStatement("insert into schedule values(?,?,?,?)");
        ps.setString(1, sb.getScheduleID());
        ps.setString(2, sb.getShipID());
        ps.setString(3, sb.getRouteID());
        ps.setDate(4, new java.sql.Date(sb.getStartDate().getTime()));
        
        int i=ps.executeUpdate();
        if(i==1)
        {
            return str="SUCCESS";
        }  
        }
        catch(Exception sql)
        {
            sql.printStackTrace();
            str="FAIL";
        
        System.out.println(str);    
        }
        
            return "ERROR";
	}
	@Override
	public Object removeSchedule(String scheduleId) {
		int i=0;
	    try
	    {
	    ps=con.prepareStatement("delete from schedule where scheduleId=?");
	    ps.setString(1, scheduleId);
	    i=ps.executeUpdate();
	    }
	    catch(Exception sql)
	    {
	        System.out.println(sql);
	    }
	    return i;
	}
	@Override
	public ScheduleBean viewSchedule(String scheduleId) {
		ScheduleBean scb=new ScheduleBean();
	       try
	       {
	           ps=con.prepareStatement("select * from schedule where scheduleId=?");
	           ps.setString(1, scheduleId);
	           rs=ps.executeQuery();
	           if(rs.next())
	           {
	               scb.setScheduleID(rs.getString(1));
	               scb.setShipID(rs.getString(2));
	               scb.setRouteID(rs.getString(3));
	               scb.setStartDate(rs.getDate(4));
	           }
	       }
	       catch(Exception sql)
	       {
	           System.out.println(sql);
	       }
	       return scb;
	}
	@Override
	public Object modifySchedule(ScheduleBean scb) {
		try
	    {
	    ps=con.prepareStatement("update route set ShipId=?,RouteId=?,startDate=? where ScheduleId=?");
	    ps.setString(1, scb.getShipID());
	    ps.setString(2, scb.getRouteID());
	    ps.setDate(3, new java.sql.Date(scb.getStartDate().getTime()));
	    ps.setString(5, scb.getRouteID());
	   
	    int i=ps.executeUpdate();
	    if(i==1)
	    {
	        return true;
	    }
	    }
	    catch(Exception sql)
	    {
	        
	        return false;
	    }
	    return false;
	}
	@Override
	public ArrayList<ShipBean> viewAllShip() 
	{
		ArrayList<ShipBean> allShips=new ArrayList<ShipBean>();
		try
		{
		ps=con.prepareStatement("select * from SHIP");
		rs=ps.executeQuery();
		while(rs.next())
		{
		ShipBean sb=new ShipBean();
		sb.setShipId(rs.getString(1)); 
		sb.setShipName(rs.getString(2));
		sb.setSeatingCapacity(rs.getInt(3)); 
		sb.setReservationCapacity(rs.getInt(4));
		allShips.add(sb);
		}
		}
		catch(Exception sql)
		{
		    sql.printStackTrace();
		}

		return allShips;

	}
	@Override
	public ArrayList<RouteBean> viewAllRoutes() 
	{
		ArrayList<RouteBean> allRoutes=new ArrayList<RouteBean>();
		try
		{
		ps=con.prepareStatement("select * from ROUTE");
		rs=ps.executeQuery();
		while(rs.next())
		{
		RouteBean rb=new RouteBean();
		rb.setRouteID(rs.getString(1)); 
		rb.setSource(rs.getString(2));
		rb.setDestination(rs.getString(3)); 
		rb.setTravelDuration(rs.getString(4));
		rb.setFare(rs.getDouble(5));
		allRoutes.add(rb);
		}
		}
		catch(Exception sql)
		{
		    sql.printStackTrace();
		}

		return allRoutes;
	}
	@Override
	public ArrayList<ScheduleBean> viewAllSchedules() 
	{
		ArrayList<ScheduleBean> allSchedules=new ArrayList<ScheduleBean>();
		try
		{
		ps=con.prepareStatement("select * from schedule");
		rs=ps.executeQuery();
		while(rs.next())
		{
		ScheduleBean sb=new ScheduleBean();
		sb.setScheduleID(rs.getString(1)); 
		sb.setShipID(rs.getString(2));
		sb.setRouteID(rs.getString(3)); 
		sb.setStartDate(rs.getDate(4));
		allSchedules.add(sb);
		}
		}
		catch(Exception sql)
		{
		    sql.printStackTrace();
		}

		return allSchedules;
	}
	public ArrayList<PassengerBean> viewPassengersByShip(String scheduleId) 
	{
		ArrayList<PassengerBean> passengers=new ArrayList<PassengerBean>();
		try
		{
		ps=con.prepareStatement("select * from passengers where scheduleid=?");
		ps.setString(1, scheduleId);
		rs=ps.executeQuery();
		while(rs.next())
		{
		PassengerBean pb=new PassengerBean();
		pb.setReservationID(rs.getString(1)); 
		pb.setScheduleID(rs.getString(2));
		pb.setName(rs.getString(3)); 
		pb.setAge(rs.getInt(4));
		pb.setGender(rs.getString(5));
		passengers.add(pb);
		}
		}
		catch(Exception sql)
		{
		    sql.printStackTrace();
		}

		return passengers;
	}


}

package com.rcb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil 
{
	public static Connection con;
    public static PreparedStatement ps;
    public static ResultSet rs;

public static Connection getDBConnection(String driverType)
{
    try
    {
    Class.forName(driverType);
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rcb","root","Root");
    System.out.println("Connected successfully...");
    }
    catch(ClassNotFoundException cnf)
    {
        System.out.println(cnf);
    }
    catch(SQLException sql)
    {
        System.out.println(sql);
    }
    return con;
}
}

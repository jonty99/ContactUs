package com.learning;

import java.sql.*;

public class ConnectDb {

	public static void main(String[] args) throws Exception
	{
		String url="jdbc:postgresql://localhost:5432/Rental";
		String uname="postgres";
	    String password="Aw@ke4297";
	    String query="select first_name from actor where actor_id=7";
		
		Class.forName("org.postgresql.Driver");
		Connection con= DriverManager.getConnection(url,uname,password);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		rs.next();
		String name=rs.getString("first_name");
		
		System.out.println(name);
		st.close();
		con.close();

	}

}

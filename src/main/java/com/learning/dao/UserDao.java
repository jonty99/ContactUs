package com.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.learning.object.CreateUser;
import com.learning.object.Request;

public class UserDao {

	public boolean verifyCredentials(CreateUser cu) throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/LoginUser";
		String uname = "postgres";
		String password = "Aw@ke4297";

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		String query = "Select * from verifyuser where email=? and password=?";
		PreparedStatement statement = con.prepareStatement(query);

		statement.setString(1, cu.getUsername());
		statement.setString(2, cu.getPassword());
		
		//System.out.println(cu.getUsername()+ cu.getPassword());

		if (statement.executeQuery().next()) {
			
			return true;
		}

		return false;

	}
}

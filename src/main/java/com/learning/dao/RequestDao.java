package com.learning.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.learning.object.Request;

public class RequestDao {

	public boolean saveRequest(Request contactInfo) throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/LoginUser";
		String uname = "postgres";
		String password = "Aw@ke4297";

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		String query = "Insert into userdetails values(?,?,?)";
		PreparedStatement statement = con.prepareStatement(query);

		statement.setString(1, contactInfo.getFullName());
		statement.setString(2, contactInfo.getEmailId());
		statement.setString(3, contactInfo.getMessage());

		if (statement.executeUpdate() != 0) {
			con.close();
			return true;
		}

		return false;
	}

}

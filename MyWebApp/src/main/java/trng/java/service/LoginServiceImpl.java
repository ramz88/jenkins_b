package trng.java.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import trng.java.bean.LoginRequest;

public class LoginServiceImpl implements LoginServiceInterface {
	@Override
	public boolean verifyLogin(LoginRequest request) {

		String userid = request.getUsername();
		String password = request.getPassword();
		System.out.println("request Data" + request);
		String sql = "select * from loginData where userid = ? and password = ?";
		PreparedStatement pst;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "password");
			pst = con.prepareStatement(sql);
			pst.setString(1, userid);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}	
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		System.out.println("No elements found");
		return false;
	}
}

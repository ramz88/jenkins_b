package trng.java.util;

import javax.servlet.http.HttpServletRequest;

import trng.java.bean.LoginRequest;


public class LoginUtility {
	public static LoginRequest prepareLoginRequest(HttpServletRequest request) {
		String username = request.getParameter("userID");
		String password = request.getParameter("password");
		
		return new LoginRequest(username,password);
	}
}

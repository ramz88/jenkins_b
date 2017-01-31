package trng.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trng.java.bean.LoginRequest;
import trng.java.service.LoginServiceImpl;
import trng.java.service.LoginServiceInterface;
import trng.java.util.LoginUtility;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init method called");
		config = getServletConfig();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	// Receive the request
		LoginRequest loginRequest = LoginUtility.prepareLoginRequest(request);
		LoginServiceInterface loginService = new LoginServiceImpl();
	//	System.out.println(loginRequest);
		boolean eligible = loginService.verifyLogin(loginRequest);
		generateResponse(eligible, response);
	}

	private void generateResponse(boolean eligible, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		if (eligible) {
			response.getWriter().append("<html> <body> <h3> Successful Login </h3></body></html>");
		} else {
			response.getWriter().append("<html> <body> <h3> <font color='red'> Login Unsuccessful</h3><br>"
					+ "<h2><a href=" + "LoginPage.jsp" + ">Click to Re-Login</a></h2></body></html>");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

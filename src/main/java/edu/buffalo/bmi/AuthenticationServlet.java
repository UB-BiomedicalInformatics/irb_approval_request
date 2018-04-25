package edu.buffalo.bmi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Map.Entry;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("username");
		String password = request.getParameter("password");
		if ((user != null) && (password != null)) {
			UserCallbackHandler userCallbackHandler = new UserCallbackHandler(
					user, password);
			boolean authenticationFlag = true;
			try {
				LoginContext loginContext = new LoginContext("loginConfig",
						userCallbackHandler);
				loginContext.login();
			} catch (LoginException e) {
				System.out.println("exception");
				authenticationFlag = false;
				System.out.println("cause of excp" + e.getMessage());
			}
			if (authenticationFlag) {
				System.out.println("authentication success");
			} else {
				System.out.println("authentication failure");
			}
		} else {
			System.out.println("invalid authentication");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}

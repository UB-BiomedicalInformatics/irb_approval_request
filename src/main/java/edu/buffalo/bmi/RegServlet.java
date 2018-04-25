package edu.buffalo.bmi;

import java.io.IOException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
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

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegServlet() {
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
		System.out.println("inside doget of regservlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("inside dopost of regservlet");
		HttpSession session = request.getSession();
		String login = request.getParameter("login");
		String register = request.getParameter("register");
		String regsubmit = request.getParameter("registerUser");
		String submitConsent = request.getParameter("submitConsent");
		String submitDescription = request.getParameter("submitDescription");
		LoginBean loginBean = new LoginBean();

		try {

			if (register != null && register.equals("Register")) {
				System.out.println("inside register");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/register.jsp");
				dispatcher.forward(request, response);
			} else if (regsubmit != null && regsubmit.equals("Register")) {
				String username = request.getParameter("txtUserName");
				String fname = request.getParameter("fname");
				String lname = request.getParameter("lname");
				String registeruser = request.getParameter("txtUserName");
				String registerpwd = request.getParameter("txtPassword");
				int registered = DbManager.getUserId(username);
				if (!String.valueOf((Object) registered).equals("0")) {
					session.setAttribute("duplicate", "duplicate");
					session.setAttribute("fname", fname);
					session.setAttribute("lname", lname);
					session.setAttribute("registeruser", registeruser);
					session.setAttribute("registerpwd", registerpwd);
					RequestDispatcher dispatcher = getServletContext()
							.getRequestDispatcher("/register.jsp");
					dispatcher.forward(request, response);
				} else {
					session.setAttribute("fname", fname);
					session.setAttribute("lname", lname);
					session.setAttribute("registeruser", registeruser);
					session.setAttribute("registerpwd", registerpwd);

					if (fname != null && !fname.isEmpty() && lname != null
							&& !lname.isEmpty() && registeruser != null
							&& !registeruser.isEmpty() && registerpwd != null
							&& !registerpwd.isEmpty()) {

						loginBean.setFname(fname);
						loginBean.setLname(lname);
						loginBean.setUsername(registeruser);
						loginBean.setPassword(registerpwd);
						try {
							DbManager.InsertUserInDB(loginBean);
							int UserId = DbManager.getUserId(registeruser);
							DbManager.InsertIntoUserRole(UserId);
							session.setAttribute("message", "message");
							session.setAttribute("username",
									loginBean.getUsername());
							RequestDispatcher dispatcher = getServletContext()
									.getRequestDispatcher(
											"/Login.jsp");
							dispatcher.forward(request, response);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else if (fname == null || fname.isEmpty()
							|| lname == null || lname.isEmpty()
							|| registeruser == null || registeruser.isEmpty()
							|| registerpwd == null || registerpwd.isEmpty()) {// if
																				// any
																				// of
																				// the
																				// fields
																				// are
																				// null
						session.setAttribute("registrationErr",
								"registrationErr");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher(
										"/register.jsp");
						dispatcher.forward(request, response);
						// return error: Please enter all the fields and go back
						// to register
					}
				}
			}
			if (login != null && login.equals("Login")) {
				System.out.println("inside login");
				String userName = request.getParameter("txtUserName");
				String password = request.getParameter("txtPassword");
				loginBean.setUsername(userName);
				loginBean.setPassword(password);

				if ((userName != null) && (password != null)) {
					System.out.println("inside username and pwd not null");
					UserCallbackHandler userCallbackHandler = new UserCallbackHandler(
							userName, password);
					boolean authenticationFlag = true;
					try {
						System.out
								.println("inside try of username nd pwd not null");
						LoginContext loginContext = new LoginContext(
								"loginConfig", userCallbackHandler);
						loginContext.login();
					} catch (LoginException e) {
						System.out
								.println("inside catch of username and pwd not null");
						authenticationFlag = false;
						System.out.println(e.getMessage());
						session.setAttribute("wronguser", userName);
						session.setAttribute("wrongpassword", password);
						session.setAttribute("authFail", "authFail");
						RequestDispatcher dispatcher = getServletContext()
								.getRequestDispatcher("/Login.jsp");
						dispatcher.forward(request, response);
					}
					if (authenticationFlag) {
						System.out.println("authentication success");
						int role = DbManager.getRole(userName);
						if (role == 1 || role == 2) {// reviewer/researcher
							try {
								int checkUser = DbManager.checkUser(loginBean);
								if (checkUser == 1) {
									System.out.println("inside checkuser==1");
									session.setAttribute("userName", userName);
									RequestDispatcher dispatcher = getServletContext()
											.getRequestDispatcher(
													"/consent.jsp");
									dispatcher.forward(request, response);
								} else {
									System.out
											.println("inside else of checkuser");
									RequestDispatcher dispatcher = getServletContext()
											.getRequestDispatcher(
													"/Login.jsp");
									dispatcher.forward(request, response);
								}
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalBlockSizeException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (BadPaddingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (InvalidParameterSpecException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}// end-catch blocks

						}// end role-loop
					}// if-authenticationFlag
				}// end-username and password not null

			} else if (submitConsent != null
					&& submitConsent.equals("Submit Consent")) {
				System.out.println("inside consent");
				String userName = (String) session.getAttribute("userName");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher("/study.jsp");
				dispatcher.forward(request, response);
			} else if (submitDescription != null
					&& submitDescription.equals("Next")) {
				System.out.println("inside description");
				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(
								"/HumanResearchForm.jsp");
				dispatcher.forward(request, response);
			}
			// Close the connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

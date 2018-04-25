package edu.buffalo.bmi;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HIPAAWaiverServlet
 */
@WebServlet("/HIPAAWaiverServlet")
public class HIPAAWaiverServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HIPAAWaiverServlet() {
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
		System.out.println("inside doGet of HIPAAWaiver servlet");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/HIPAAWaiver.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of HIPAAWaiver servlet");
		HttpSession session = request.getSession();
		String bool1 = request.getParameter("bool1");
		String bool2 = request.getParameter("bool2");
		String bool3 = request.getParameter("bool3");
		String bool4 = request.getParameter("bool4");
		String bool5 = request.getParameter("bool5");
		String bool6 = request.getParameter("bool6");
		String bool7 = request.getParameter("bool7");
		String bool8 = request.getParameter("bool8");
		int studyID = (int) session.getAttribute("studyID");
		String investigator = (String) session.getAttribute("investigator");
		String projTitle = (String) session.getAttribute("projTitle");
		String institutionName = (String) session.getAttribute("institutionName");

		if ((request.getParameter("submitHIPAAWaiver") != null && request
				.getParameter("submitHIPAAWaiver")
				.equals("Submit HIPAA Waiver"))) {

			 try {
			 DbManager.insertIntoHIPAA(bool1,bool2,bool3,bool4,bool5,bool6,bool7,bool8,studyID);
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			if ((bool1 != null && bool1.equalsIgnoreCase("Yes1"))
					&& (bool2 != null && bool2.equalsIgnoreCase("Yes3"))
					&& (bool3 != null && bool3.equalsIgnoreCase("Yes5"))
					&& (bool4 != null && bool4.equalsIgnoreCase("Yes7"))
					&& (bool5 != null && bool5.equalsIgnoreCase("Yes9"))
					&& (bool6 != null && bool6.equalsIgnoreCase("Yes11"))
					&& (bool7 != null && bool7.equalsIgnoreCase("Yes13"))
					&& (bool8 != null && bool8.equalsIgnoreCase("Yes15"))) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/WaiverOfConsent.jsp");
				rd.forward(request, response);
			} else {
				// important forward it back to the login page again.
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
		}
	}

}

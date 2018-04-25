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
 * Servlet implementation class WaiverConsentServlet
 */
@WebServlet("/WaiverConsentServlet")
public class WaiverConsentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WaiverConsentServlet() {
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
		System.out.println("inside doGet of WaiverConsent servlet");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/WaiverOfConsent.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of WaiverConsent servlet");
		HttpSession session = request.getSession();
		String var1 = request.getParameter("var1");
		String var2 = request.getParameter("var2");
		String var3 = request.getParameter("var3");
		String var4 = request.getParameter("var4");
		String var5 = request.getParameter("var5");
		int studyID = (int) session.getAttribute("studyID");
		String investigator = (String) session.getAttribute("investigator");
		String projTitle = (String) session.getAttribute("projTitle");
		String institutionName = (String) session.getAttribute("institutionName");

		if ((request.getParameter("submitWaiverOfConsent") != null && request
				.getParameter("submitWaiverOfConsent").equals(
						"Submit Consent Waiver"))) {

			 try {
			 DbManager.insertIntoConsentWaiver(var1,var2,var3,var4,var5,studyID);
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }

			if ((var1 != null && var1.equalsIgnoreCase("Yes1"))
					&& (var2 != null && var2.equalsIgnoreCase("Yes3"))
					&& (var3 != null && var3.equalsIgnoreCase("Yes5"))
					&& (var4 != null && var4.equalsIgnoreCase("Yes7"))
					&& (var5 != null && var5.equalsIgnoreCase("Yes9"))) {
				// change status to Approved Expedited
				try {
					DbManager.updateStatus(studyID, 3);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			} else {
				// change status to IRB Full Review
				try {
					DbManager.updateStatus(studyID, 1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// important forward it back to the login page again.
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
		}
	}
}

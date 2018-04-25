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
 * Servlet implementation class IRB_ExemptServlet
 */
@WebServlet("/IRB_ExpeditedServlet")
public class IRB_ExpeditedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IRB_ExpeditedServlet() {
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
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/IRB_ExpeditedDtls.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of Expedited servlet");
		HttpSession session = request.getSession();
		String ele1 = request.getParameter("ele1");
		String ele2 = request.getParameter("ele2");
		String ele3 = request.getParameter("ele3");
		String ele4 = request.getParameter("ele4");
		String ele5 = request.getParameter("ele5");
		String ele6 = request.getParameter("ele6");
		String ele7 = request.getParameter("ele7");
		String ele8 = request.getParameter("ele8");
		int studyID = (int) session.getAttribute("studyID");
		String investigator = (String) session.getAttribute("investigator");
		String projTitle = (String) session.getAttribute("projTitle");
		String institutionName = (String) session.getAttribute("institutionName");

		if ((request.getParameter("submitExpedited") != null && request
				.getParameter("submitExpedited").equals("Submit"))) {
			 try {
			 DbManager.insertIntoExpedited(ele1,ele2,ele3,ele4,ele5,ele6,ele7,ele8,studyID);
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }
			if ((ele1 != null && ele1.equalsIgnoreCase("Yes1"))
					&& (ele2 != null && ele2.equalsIgnoreCase("Yes3"))
					&& (ele3 != null && ele3.equalsIgnoreCase("Yes5"))
					&& (ele4 != null && ele4.equalsIgnoreCase("Yes7"))
					&& (ele5 != null && ele5.equalsIgnoreCase("Yes9"))
					&& (ele6 != null && ele6.equalsIgnoreCase("Yes11"))
					&& (ele7 != null && ele7.equalsIgnoreCase("Yes13"))
					&& (ele8 != null && ele8.equalsIgnoreCase("Yes15"))) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/HIPAAWaiver.jsp");
				rd.forward(request, response);
			} else {
				// important forward it back to the error page.
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
		}
	}
}

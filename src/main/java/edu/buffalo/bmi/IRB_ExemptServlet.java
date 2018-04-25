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
@WebServlet("/IRB_ExemptServlet")
public class IRB_ExemptServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IRB_ExemptServlet() {
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
		System.out.println("inside doGet of Exempt servlet");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/IRB_ExemptDtls.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of Exempt servlet");
		HttpSession session = request.getSession();
		String attr1 = request.getParameter("attr1");
		String attr2 = request.getParameter("attr2");
		String attr3 = request.getParameter("attr3");
		String attr4 = request.getParameter("attr4");
		String attr5 = request.getParameter("attr5");
		String attr6 = request.getParameter("attr6");
		String attr7 = request.getParameter("attr7");
		String attr8 = request.getParameter("attr8");
		String attr9 = request.getParameter("attr9");
		String attr10 = request.getParameter("attr10");
		int studyID = (int) session.getAttribute("studyID");
		String investigator = (String) session.getAttribute("investigator");
		String projTitle = (String) session.getAttribute("projTitle");
		String institutionName = (String) session.getAttribute("institutionName");

		if ((request.getParameter("submitExempt") != null && request
				.getParameter("submitExempt").equals("Submit"))) {
			 try {
			 DbManager.insertIntoExempt(attr1,attr2,attr3,attr4,attr5,attr6,attr7,attr8,attr9,attr10,studyID);
			 } catch (SQLException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 }

			if ((attr8 != null && attr8.equalsIgnoreCase("Yes15"))
					&& (attr1 != null && attr1.equalsIgnoreCase("No2"))
					&& (attr2 != null && attr2.equalsIgnoreCase("No4"))
					&& (attr3 != null && attr3.equalsIgnoreCase("No6"))
					&& (attr4 != null && attr4.equalsIgnoreCase("Yes7"))
					&& (attr5 != null && attr5.equalsIgnoreCase("Yes9"))
					&& (attr6 != null && attr6.equalsIgnoreCase("Yes11"))
					&& (attr7 != null && attr7.equalsIgnoreCase("Yes13"))
					&& (attr9 != null && attr9.equalsIgnoreCase("Yes17"))
					&& (attr10 != null && attr10.equalsIgnoreCase("Yes19"))) { // if
																				// any
																				// one
																				// of
																				// the
																				// two
																				// options
																				// are
																				// "Yes",
																				// then
																				// go
																				// to
																				// expedited
			// set status to 'Full IRB Review'
				try {
					DbManager.updateStatus(studyID, 1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RequestDispatcher rd = request
						.getRequestDispatcher("/IRB_ExpeditedDtls.jsp");
				rd.forward(request, response);
			} else if ((attr1 != null && attr1.equalsIgnoreCase("No2"))
					&& (attr2 != null && attr2.equalsIgnoreCase("No4"))
					&& (attr3 != null && attr3.equalsIgnoreCase("No6"))
					&& (attr4 != null && attr4.equalsIgnoreCase("Yes7"))
					&& (attr5 != null && attr5.equalsIgnoreCase("Yes9"))
					&& (attr6 != null && attr6.equalsIgnoreCase("Yes11"))
					&& (attr7 != null && attr7.equalsIgnoreCase("Yes13"))
					&& (attr8 != null && attr8.equalsIgnoreCase("No16"))
					&& (attr9 != null && attr9.equalsIgnoreCase("Yes17"))
					&& (attr10 != null && attr10.equalsIgnoreCase("Yes19"))) {
				// set status to 'Approved Exempt'
				try {
					DbManager.updateStatus(studyID, 2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			} else {
				// set status to 'Full IRB Review'
				try {
					DbManager.updateStatus(studyID, 1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
		}
	}

}

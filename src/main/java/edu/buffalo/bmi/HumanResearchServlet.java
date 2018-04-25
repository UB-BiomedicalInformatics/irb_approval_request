package edu.buffalo.bmi;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IRB_HumanResearchServlet
 */
@WebServlet("/HumanResearchServlet")
public class HumanResearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HumanResearchServlet() {
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
		System.out.println("inside doGet of Human Research servlet");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/HumanResearchForm.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of Human Research servlet");
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
		String attr11 = request.getParameter("attr11");
		String attr12 = request.getParameter("attr12");
		int studyID = (int) session.getAttribute("studyID");
		String investigator = (String) session.getAttribute("investigator");
		String projTitle = (String) session.getAttribute("projTitle");
		String institutionName = (String) session.getAttribute("institutionName");

		if ((request.getParameter("submitHumanResearch") != null && request
				.getParameter("submitHumanResearch").equals(
						"Submit Human Research"))) {

			 try {
			 DbManager.insertIntoHumanResearch(attr1,attr2,attr3,attr4,attr5,attr6,attr7,attr8,attr9,attr10,attr11,attr12,studyID);
			 } catch (SQLException e) {
//			 TODO Auto-generated catch block
			 e.printStackTrace();
			 }

			if ((attr1 != null && attr1.equalsIgnoreCase("Yes1"))
					&& (attr2 != null && attr2.equalsIgnoreCase("Yes3"))
					&& (attr3 != null && attr3.equalsIgnoreCase("Yes5"))
					&& (attr4 != null && attr4.equalsIgnoreCase("Yes7"))
					&& (attr5 != null && attr5.equalsIgnoreCase("Yes9"))
					&& (attr6 != null && attr6.equalsIgnoreCase("No12"))
					&& (attr7 != null && attr7.equalsIgnoreCase("No14"))
					&& (attr8 != null && attr8.equalsIgnoreCase("Yes15"))
					&& (attr9 != null && attr9.equalsIgnoreCase("No18"))
					&& (attr10 != null && attr10.equalsIgnoreCase("No20"))
					&& (attr11 != null && attr11.equalsIgnoreCase("No22"))
					&& (attr12 != null && attr12.equalsIgnoreCase("No24"))) {

				RequestDispatcher rd = request
						.getRequestDispatcher("/IRB_ExemptDtls.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Success.jsp");
				rd.forward(request, response);
			}
		} else {
			// set the error message request variable
			request.setAttribute("errorMessage", "Form not submitted");
			// important forward it back to the login page again.
			RequestDispatcher rd = request
					.getRequestDispatcher("/HumanResearchForm.jsp");
			rd.forward(request, response);
		}
	}

}

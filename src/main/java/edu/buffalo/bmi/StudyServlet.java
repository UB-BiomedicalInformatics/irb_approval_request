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
 * Servlet implementation class StudyServlet
 */
@WebServlet("/StudyServlet")
public class StudyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	InputStream input = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudyServlet() {
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
		System.out.println("inside doGet of StudyServlet");
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/study.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside doPost of StudyServlet");
		HttpSession session = request.getSession();
		String createStudy = request.getParameter("createStudy");
		String investigator = request.getParameter("investigator");
		String projTitle = request.getParameter("projTitle");
		String institution = request.getParameter("institution");
		int userId = 0;
		int studyStatus = 1;
		int studyID = 0;
		StudyBean studyBean = new StudyBean();
		String userName = (String) session.getAttribute("userName");

		if (investigator != null && !investigator.isEmpty()
				&& projTitle != null && !projTitle.isEmpty()
				&& institution != null && !institution.isEmpty()) {
			try {
				userId = DbManager.getUserId(userName);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (createStudy != null && createStudy.equals("Create Study")) {
				System.out.println("inside create study");

				session.setAttribute("investigator", investigator);
				session.setAttribute("projTitle", projTitle);
				session.setAttribute("institution", institution);

				studyBean.setComments("");
				studyBean.setUserId(String.valueOf(userId));
				studyBean.setStatus(studyStatus);
				studyBean.setInvestigator(investigator);
				studyBean.setProjectTitle(projTitle);
				studyBean.setInstitution(institution);
				try {
					DbManager.CreateStudy(studyBean);
					studyID = DbManager.getStudyID(investigator, projTitle, institution);
					System.out.println("StudyID:" + studyID);
					session.setAttribute("studyID", studyID);
				} catch (ClassNotFoundException e) {
//					 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
//					 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RequestDispatcher dispatcher = getServletContext()
						.getRequestDispatcher(
								"/HumanResearchForm.jsp");
				dispatcher.forward(request, response);
			} else {
				// set the error message request variable
				request.setAttribute("errorMessage", "Form not submitted");
				// important forward it back to the login page again.
				RequestDispatcher rd = request
						.getRequestDispatcher("/study.jsp");
				rd.forward(request, response);
			}
		} else {
			System.out.println("inside else of study servlet");
			session.setAttribute("investigator", investigator);
			session.setAttribute("projTitle", projTitle);
			session.setAttribute("institution", institution);
			session.setAttribute("noStudyDetails", "noStudyDetails");
			RequestDispatcher rd = request
					.getRequestDispatcher("/study.jsp");
			rd.forward(request, response);
		}

	}
}

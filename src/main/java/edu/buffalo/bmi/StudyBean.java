package edu.buffalo.bmi;

public class StudyBean {

	private int Status;
	private String Comments;
	private String UserId;
	private String Investigator;
	private String ProjectTitle;
	private String Institution;

	public String getInstitution() {
		return Institution;
	}

	public void setInstitution(String institution) {
		Institution = institution;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getInvestigator() {
		return Investigator;
	}

	public void setInvestigator(String investigator) {
		Investigator = investigator;
	}

	public String getProjectTitle() {
		return ProjectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		ProjectTitle = projectTitle;
	}

}

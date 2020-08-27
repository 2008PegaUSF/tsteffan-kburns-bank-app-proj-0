package bank;

import java.io.Serializable;

public class Applications implements Serializable {
	public static final long serialVersionUID = 7162534L;
	
	Boolean approved = false;
	String applicant;
	int appID;
	
	public Applications(Boolean approved, String applicant, int appID) {
		this.approved = approved;
		this.applicant = applicant;
		this.appID = appID;
	}

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
}

package kr.co.green.member.model.dto;

import java.util.Date;

public class MemberBoardDTO {
	 private String projectName;
	    private String projectIntroduce;
	    private String projectContent;
	    private String projectKind;
	    private int projectTargetAmount;
	    private int projectCurrentAmount;
	    private int projectSponserNumber;
	    private String projectConfirmStatus;
	    private Date projectRegisterDate;
	    private Date projectEndDate;
	    private String projectOuterImageName;
	    private String projectOuterImagePath;
	    
	    
		public String getProjectName() {
			return projectName;
		}
		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}
		public String getProjectIntroduce() {
			return projectIntroduce;
		}
		public void setProjectIntroduce(String projectIntroduce) {
			this.projectIntroduce = projectIntroduce;
		}
		public String getProjectContent() {
			return projectContent;
		}
		public void setProjectContent(String projectContent) {
			this.projectContent = projectContent;
		}
		public String getProjectKind() {
			return projectKind;
		}
		public void setProjectKind(String projectKind) {
			this.projectKind = projectKind;
		}
		public int getProjectTargetAmount() {
			return projectTargetAmount;
		}
		public void setProjectTargetAmount(int projectTargetAmount) {
			this.projectTargetAmount = projectTargetAmount;
		}
		public int getProjectCurrentAmount() {
			return projectCurrentAmount;
		}
		public void setProjectCurrentAmount(int projectCurrentAmount) {
			this.projectCurrentAmount = projectCurrentAmount;
		}
		public int getProjectSponserNumber() {
			return projectSponserNumber;
		}
		public void setProjectSponserNumber(int projectSponserNumber) {
			this.projectSponserNumber = projectSponserNumber;
		}
		public String getProjectConfirmStatus() {
			return projectConfirmStatus;
		}
		public void setProjectConfirmStatus(String projectConfirmStatus) {
			this.projectConfirmStatus = projectConfirmStatus;
		}
		public Date getProjectRegisterDate() {
			return projectRegisterDate;
		}
		public void setProjectRegisterDate(Date projectRegisterDate) {
			this.projectRegisterDate = projectRegisterDate;
		}
		public Date getProjectEndDate() {
			return projectEndDate;
		}
		public void setProjectEndDate(Date projectEndDate) {
			this.projectEndDate = projectEndDate;
		}
		public String getProjectOuterImageName() {
			return projectOuterImageName;
		}
		public void setProjectOuterImageName(String projectOuterImageName) {
			this.projectOuterImageName = projectOuterImageName;
		}
		public String getProjectOuterImagePath() {
			return projectOuterImagePath;
		}
		public void setProjectOuterImagePath(String projectOuterImagePath) {
			this.projectOuterImagePath = projectOuterImagePath;
		}
	    
	    
}

package kr.co.green.member.model.dto;

import java.util.Date;

public class MemberBoardDTO {
		private int projectNo;
	 	private String projectName;
	    private String projectIntroduce;
	    private String projectContent;
	    private String projectKind;
		private int projectTargetAmount;
	    private int projectCurrentAmount;
	    private double projectCurrentPercentage;
	    private int projectSponserNumber;
	    private String projectConfirmStatus;
	    private String projectRegisterDate;
	    private String projectEndDate;
	    private String projectOuterImageName;
	    private String projectOuterImagePath;
	    private String projectManagerName;
	    private long projectRemainDate;
	    
	    
	    
	    public long getProjectRemainDate() {
			return projectRemainDate;
		}
		public void setProjectRemainDate(long projectRemainDate) {
			this.projectRemainDate = projectRemainDate;
		}
		public double getProjectCurrentPercentage() {
			return projectCurrentPercentage;
		}
		public void setProjectCurrentPercentage(double projectCurrentPercentage) {
			this.projectCurrentPercentage = projectCurrentPercentage;
		}
		public int getProjectNo() {
			return projectNo;
		}
		public void setProjectNo(int projectNo) {
			this.projectNo = projectNo;
		}
		public String getProjectManagerName() {
			return projectManagerName;
		}
		public void setProjectManagerName(String projectManagerName) {
			this.projectManagerName = projectManagerName;
		}
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
		public String getProjectRegisterDate() {
			return projectRegisterDate;
		}
		public void setProjectRegisterDate(String projectRegisterDate) {
			this.projectRegisterDate = projectRegisterDate;
		}
		public String getProjectEndDate() {
			return projectEndDate;
		}
		public void setProjectEndDate(String projectEndDate) {
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

package kr.co.green.project.model.dto;

public class ProjectDTO {
//	프로젝트
	private int projectNo;
	private String projectName;
	private String projectIntroduce;
	private String projectContent;
	private String projectKind;
	private int projectPrice;
	private int projectTargetAmount;
	private int projectCurrentAmount;
	private int projectCurrentPercentage ;
	private int projectSponserNumber;
	private String projectConfirmStatus;
	private String projectSaleStatus;
	private String projectRegisterDate;
	private String projectEndDate;
	private String projectOuterImageName;
	private String projectOuterImagePath;
	private long projectRemainDate;

//	상세이미지
	private String projectInnerImageName;
	private String projectInnerImagePath;

//	창작자
	private int projectManagerNo;
	private String projectManagerName;
	private String projectManagerIntroduce;
	private String projectManagerImageName;
	private String projectManagerImagePath;
	private String projectManagerAccount;

	public int getProjectManagerNo() {
		return projectManagerNo;
	}

	public void setProjectManagerNo(int projectManagerNo) {
		this.projectManagerNo = projectManagerNo;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public String getProjectConfirmStatus() {
		return projectConfirmStatus;
	}

	public void setProjectConfirmStatus(String projectConfirmStatus) {
		this.projectConfirmStatus = projectConfirmStatus;
	}

	public String getProjectSaleStatus() {
		return projectSaleStatus;
	}

	public void setProjectSaleStatus(String projectSaleStatus) {
		this.projectSaleStatus = projectSaleStatus;
	}

	// api로부터 결제된 프로젝트 정보 받기(후에 donate테이블 저장)
	public ProjectDTO(String projectName, int projectPrice, int projectNo) {
		super();
		this.projectName = projectName;
		this.projectPrice = projectPrice;
		this.projectNo = projectNo;
	}

	public ProjectDTO() {
	}

	public long getProjectRemainDate() {
		return projectRemainDate;
	}

	public void setProjectRemainDate(long projectRemainDate) {
		this.projectRemainDate = projectRemainDate;
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

	public int getProjectPrice() {
		return projectPrice;
	}

	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
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



	public String getProjectInnerImageName() {
		return projectInnerImageName;
	}

	public void setProjectInnerImageName(String projectInnerImageName) {
		this.projectInnerImageName = projectInnerImageName;
	}

	public String getProjectInnerImagePath() {
		return projectInnerImagePath;
	}

	public void setProjectInnerImagePath(String projectInnerImagePath) {
		this.projectInnerImagePath = projectInnerImagePath;
	}

	public String getProjectManagerName() {
		return projectManagerName;
	}

	public void setProjectManagerName(String projectManagerName) {
		this.projectManagerName = projectManagerName;
	}

	public String getProjectManagerIntroduce() {
		return projectManagerIntroduce;
	}

	public void setProjectManagerIntroduce(String projectManagerIntroduce) {
		this.projectManagerIntroduce = projectManagerIntroduce;
	}

	public String getProjectManagerImageName() {
		return projectManagerImageName;
	}

	public void setProjectManagerImageName(String projectManagerImageName) {
		this.projectManagerImageName = projectManagerImageName;
	}

	public String getProjectManagerAccount() {
		return projectManagerAccount;
	}

	public void setProjectManagerAccount(String projectManagerAccount) {
		this.projectManagerAccount = projectManagerAccount;
	}

	public String getProjectManagerImagePath() {
		return projectManagerImagePath;
	}

	public void setProjectManagerImagePath(String projectManagerImagePath) {
		this.projectManagerImagePath = projectManagerImagePath;
	}


	public int getProjectCurrentPercentage() {
		return projectCurrentPercentage;
	}

	public void setProjectCurrentPercentage(int projectCurrentPercentage) {
		this.projectCurrentPercentage = projectCurrentPercentage;
	}

}

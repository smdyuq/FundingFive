package kr.co.green.project.model.dto;

public class ProjectDTO {
	private int projectNumber;
	private String projectName;
	private String projectIntroduce;
	private String projectContent;
	private String projectKind;
	private int projectPrice;
	private int projectTargetAmount;
	private int projectCurrentAmount;
	private int projectCurrentPercentage;
	private int projectSponserNumber;
	private String projectRegisterDate;
	private String projectEndDate;
	private String projectOuterImageName;
	private String projectOuterImagePath;
	private long projectRemainDate;
	
	//api로부터 결제된 프로젝트 정보 받기(후에 donate테이블 저장)
	public ProjectDTO( String projectName, int projectPrice, int projectNumber) {
		super();
		this.projectName = projectName;
		this.projectPrice = projectPrice;
		this.projectNumber = projectNumber;
	}
	
	public ProjectDTO() {
	}

	public long getProjectRemainDate() {
		return projectRemainDate;
	}
	public void setProjectRemainDate(long projectRemainDate) {
		this.projectRemainDate = projectRemainDate;
	}
	private String ProjectInnerImageName;
	private String ProjectInnerImagePath;
	
	private String projectManagerName;
	private String projectManagerIntroduce;
	private String projectManagerImageName;
	private String projectManagerImagePath;
	private String projectMangerAccount;
	
	
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
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
		return ProjectInnerImageName;
	}
	public void setProjectInnerImageName(String projectInnerImageName) {
		ProjectInnerImageName = projectInnerImageName;
	}
	public String getProjectInnerImagePath() {
		return ProjectInnerImagePath;
	}
	public void setProjectInnerImagePath(String projectInnerImagePath) {
		ProjectInnerImagePath = projectInnerImagePath;
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
	public String getProjectManagerImagePath() {
		return projectManagerImagePath;
	}
	public void setProjectManagerImagePath(String projectManagerImagePath) {
		this.projectManagerImagePath = projectManagerImagePath;
	}
	public String getProjectMangerAccount() {
		return projectMangerAccount;
	}
	public void setProjectMangerAccount(String projectMangerAccount) {
		this.projectMangerAccount = projectMangerAccount;
	}

	public int getProjectCurrentPercentage() {
		return projectCurrentPercentage;
	}

	public void setProjectCurrentPercentage(int projectCurrentPercentage) {
		this.projectCurrentPercentage = projectCurrentPercentage;
	}
	
	
	
}

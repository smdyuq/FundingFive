package kr.co.green.projectlee.dto;

public class ProjectleeDTO {

//	프로젝트
	private int projectNo; // 프로젝트 번호
	private String projectName; // 프로젝트 이름
	private String projectIntroduce; // 프로젝트 소개
	private String projectContent; // 프로젝트 상세내용
	private String projectKind; // 프로젝트 종류
	private int projectPrice; // 프로젝트 가격
	private int projectTargetAmount; // 프로젝트 목표 후원금액
	private int projectCurrentAmount; // 현재 후원된 금액
	private int projectSponserNumber; // 프로젝트 후원자 수
	private String projectConfirmStatus; // 프로젝트 승인유무
	private String projectSaleStatus; // 프로젝트 판매유무
	private String projectRegisterDate; // 프로젝트 등록일
	private String projectEndDate; // 프로젝트 마감일
	private String projectOuterImageName; // 프로젝트 대표 이미지 이름
	private String projectOuterImagePath; // 프로젝트 대표 이미지 경로

//	창작자
	private int managerNo; // 창작자 번호
	private String managerName; // 창작자 이름
	private String managerIntroduce; // 창작자 소개
	private String managerImageName; // 창작자 사진 이름
	private String managerImagePath; // 창작자 사진 경로
	private String managerAccount; // 창작자 입금계좌

//	프로젝트 내부 이미지

	private String projectInnerImageName; // 프로젝트 내부 이미지 이름
	private String projectInnerImagePath; // 프로젝트 내부 이미지 경로

//	getter / setter

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
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

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerIntroduce() {
		return managerIntroduce;
	}

	public void setManagerIntroduce(String managerIntroduce) {
		this.managerIntroduce = managerIntroduce;
	}

	public String getManagerImageName() {
		return managerImageName;
	}

	public void setManagerImageName(String managerImageName) {
		this.managerImageName = managerImageName;
	}

	public String getManagerImagePath() {
		return managerImagePath;
	}

	public void setManagerImagePath(String managerImagePath) {
		this.managerImagePath = managerImagePath;
	}

	public String getManagerAccount() {
		return managerAccount;
	}

	public void setManagerAccount(String managerAccount) {
		this.managerAccount = managerAccount;
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

}

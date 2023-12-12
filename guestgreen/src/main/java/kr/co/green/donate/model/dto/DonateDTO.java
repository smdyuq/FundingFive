package kr.co.green.donate.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonateDTO {
	private String donateId;
	private int projectNo;
	private String projectName;
	private int memberNo;
	private String memberName;
	private String memberAddr;
	private String memberPhone;
	private int projectPrice;
	
	
	public String getDonateId() {
		return donateId;
	}
	public void setDonateId(String donateId) {
		this.donateId = donateId;
	}
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
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public int getProjectPrice() {
		return projectPrice;
	}
	public void setProjectPrice(int projectPrice) {
		this.projectPrice = projectPrice;
	}
	
	
	
}

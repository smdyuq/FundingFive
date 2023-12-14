package kr.co.green.member.model.dto;

public class MemberDTO {
	
	private int memberNo;
	
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	
	private String memberCreateDate;
	private String memberUpdateDate;
	
	private int memberType = 1;

	
	//api로부터 결제된 회원 정보 받기(후에 donate테이블 저장)
	public MemberDTO(String memberName, String memberPhone, String memberAddr, int memberNo) {
		super();
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
		this.memberNo = memberNo;
	}

	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String memberId, String memberName, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPwd = memberPwd;
	}
	
	
	public MemberDTO(String memberId, String memberPwd, String memberName, String memberPhone, String memberAddr) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberAddr = memberAddr;
	}
	
	public MemberDTO(String memberId, String memberName, String memberPhone, String memberAddr) {
	    super();
	    this.memberId = memberId;
	    this.memberName = memberName;
	    this.memberPhone = memberPhone;
	    this.memberAddr = memberAddr;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}

	public String getMemberCreateDate() {
		return memberCreateDate;
	}

	public void setMemberCreateDate(String memberCreateDate) {
		this.memberCreateDate = memberCreateDate;
	}

	public String getMemberUpdateDate() {
		return memberUpdateDate;
	}

	public void setMemberUpdateDate(String memberUpdateDate) {
		this.memberUpdateDate = memberUpdateDate;
	}

	public int getMemberType() {
		return memberType;
	}

	public void setMemberType(int memberType) {
		this.memberType = memberType;
	}
	



	
	
	
	
	

}

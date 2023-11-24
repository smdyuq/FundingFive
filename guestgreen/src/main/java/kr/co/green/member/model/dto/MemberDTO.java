package kr.co.green.member.model.dto;

public class MemberDTO {
	
	private int no;
	
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String addr;
	
	private String createDate;
	private String updateDate;
	
	private int type;

	
	//api로부터 결제된 회원 정보 받기(후에 donate테이블 저장)
	public MemberDTO(String name, String phone, String addr, int no) {
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.no = no;
	}

	public MemberDTO() {
		super();
	}
	
	public MemberDTO(String id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	
	public MemberDTO(String id, String pwd, String name, String phone, String addr) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	
	public MemberDTO(String id, String name, String phone, String addr) {
	    super();
	    this.id = id;
	    this.name = name;
	    this.phone = phone;
	    this.addr = addr;
	}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	
	
	
	
	

}

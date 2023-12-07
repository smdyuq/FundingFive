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
	
}

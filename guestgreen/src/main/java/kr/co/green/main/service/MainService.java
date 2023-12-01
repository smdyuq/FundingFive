package kr.co.green.main.service;

import java.util.ArrayList;

import kr.co.green.common.PageInfo;
import kr.co.green.main.dto.MainDTO;

public interface MainService {
	
	public int mainListCount();
	
	public ArrayList<MainDTO> mainSelect(PageInfo pi);

}

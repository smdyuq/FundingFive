package kr.co.green.main.service;

import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;

public interface MainService {

//   배너 조회
   public ArrayList<ProjectDTO> bannerSelect();

//  주목할만한 프로젝트 조회
   public ArrayList<ProjectDTO> noteworthySelect();

//  인기 프로젝트 조회
   public ArrayList<ProjectDTO> popularitySelect();

//   마감 임박 프로젝트 조회
   public ArrayList<ProjectDTO> DeadlineSelect();
   
//   최근 본 프로젝트 조회
   public ArrayList<ProjectDTO> recentProjectSelect();

//   이런 프로젝트 어때요 조회
   public ArrayList<ProjectDTO> RecommendedSelect();

//   신규 프로젝트 조회
   public ArrayList<ProjectDTO> newProjectSelect();

//   공개 예정 프로젝트 조회
   public ArrayList<ProjectDTO> soonProjectSelect();
   
//   오늘 오픈한 프로젝트 조회
   public ArrayList<ProjectDTO> todayProjectSelect();

}
package kr.co.green.main.model.service;

import java.util.ArrayList;

import kr.co.green.project.model.dto.ProjectDTO;

public interface MainService {

//   프로젝트 조회
   public void projectSelect(ArrayList<ProjectDTO>[] list);

//   인기 프로젝트 조회
   public ArrayList<ProjectDTO> projectPopularity();

}
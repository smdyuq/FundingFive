<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/project/administratorOk.css">
<script src="/resources/js/project/administratorOk.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">


</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>

	<main onload="showTabContent('project_approval');">
		<div class="project_approval-div">
			<h2>프로젝트 관리</h2>

			<div class="tabs">
				<input id="project_approval" type="radio" name="tab_item" checked
					onchange="showTabContent('project_approval')"> <label
					class="tab_item" for="project_approval">프로젝트 승인 목록</label> 
					<input
					id="project_completed" type="radio" name="tab_item"
					onchange="showTabContent('project_completed')"> <label
					class="tab_item" for="project_completed">완료된 프로젝트 목록</label>
					<input
					id="project_failure" type="radio" name="tab_item"
					onchange="showTabContent('project_failure')"> <label
					class="tab_item" for="project_failure">실패한 프로젝트 목록</label>
			</div>

			<div class="tab_content" id="project_approval_content">
				<section>
					<form id="project-administratorok-form">
						<input type="hidden" name="cpage" value="1">
						<table class="table">
							<thead>
								<tr>
									<th>프로젝트명</th>
									<th>프로젝트 등록일</th>
									<th>창작자 이름</th>

								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${empty projectList}">
										<tr>
											<td colspan="5" class="text-center">등록된 프로젝트가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="item" items="${projectList }">
											<tr onclick="projectDetail(${item.projectNo})">
												<td>${item.projectName }</td>
												<td>${item.projectRegisterDate }</td>
												<td>${item.projectManagerName }</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>

							</tbody>
						</table>

						<!-- 페이징 처리 -->
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:choose>
									<c:when test="${pi.currentPage == 1 && pi.maxPage > 0}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:when test="${pi.maxPage > 0 }">
										<li class="page-item"><a class="page-link"
											href="/administratorOk.do?cpage=${pi.currentPage-1 }"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>

								</c:choose>

								<c:forEach var="page" begin="${pi.startPage }"
									end="${pi.endPage }">
									<li class="page-item"><a class="page-link"
										href="/administratorOk.do?cpage=${page }">${page
                                                }</a></li>
								</c:forEach>

								<c:choose>

									<c:when test="${pi.currentPage == pi.maxPage}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>

										</a></li>
									</c:when>
									<c:when test="${pi.maxPage > 0 }">
										<li class="page-item"><a class="page-link"
											href="/administratorOk.do?cpage=${pi.currentPage+1 }"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
								</c:choose>
							</ul>
						</nav>
					</form>
				</section>
			</div>

			<div class="tab_content" id="project_completed_content">
				<form id="project-administratorok-form" >
					<input type="hidden" name="status" value="success">
					<table class="table">
						<thead>
							<tr>
								<th>프로젝트 번호</th>
								<th>프로젝트명</th>
								<th>프로젝트 등록일</th>
								<th>프로젝트 종료일</th>
								<th>프로젝트 달성률</th>
								<th>창작자 이름</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty successfulProjectList}">
									<tr>
										<td colspan="5" class="text-center">만료된 프로젝트가 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="item" items="${successfulProjectList}">
										<tr onclick="successfulProject(${item.projectNo})">
											<td>${item.projectNo}</td>
											<td>${item.projectName}</td>
											<td>${item.projectRegisterDate}</td>
											<td>${item.projectEndDate}</td>
											<td>${item.projectCurrentPercentage}</td>
											<td>${item.projectManagerName}</td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</tbody>
					</table>

					<!-- 페이징 처리 -->

				</form>

			</div>
			
			<div class="tab_content" id="project_failure_content">
				<form id="project-administratorok-form">
				<input type="hidden" name="status" value="fail">
					<table class="table">
						<thead>
							<tr>
								<th>프로젝트 번호</th>
								<th>프로젝트명</th>
								<th>프로젝트 등록일</th>
								<th>프로젝트 종료일</th>
								<th>프로젝트 달성률</th>
								<th>창작자 이름</th>
								
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${empty failedProjectList}">
									<tr>
										<td colspan="5" class="text-center">만료된 프로젝트가 없습니다.</td>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach var="item" items="${failedProjectList}">
										<tr onclick="failedProject(${item.projectNo})">
											<td>${item.projectNo}</td>
											<td>${item.projectName}</td>
											<td>${item.projectRegisterDate}</td>
											<td>${item.projectEndDate}</td>
											<td>${item.projectCurrentPercentage}</td>
											<td>${item.projectManagerName}</td>
										</tr>
										
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</tbody>
					</table>

					<!-- 페이징 처리 -->

				</form>

			</div>
		</div>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
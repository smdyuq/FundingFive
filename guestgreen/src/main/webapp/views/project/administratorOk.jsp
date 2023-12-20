<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/project/administratorOk.css">
<script src="/resources/js/project/apiKey.js"></script>
<script src="/resources/js/project/administratorOk.js"></script>

<style>
</style>

</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>

	<main>

		<div class="container">
			<div class="menu-container">
				<h2>프로젝트 관리</h2>
				<div class="menu ${menu == 'first' ? 'active' : '' }"
					onclick="showProject('first')">
					<span>프로젝트 승인 목록</span> <span class="menu-arrow">></span>
				</div>
				<div class="menu ${menu == 'second' ? 'active' : '' }"
					onclick="showProject('second')">
					<span>완료된 프로젝트 목록</span> <span class="menu-arrow">></span>
				</div>
				<div class="menu ${menu == 'third' ? 'active' : '' }"
					onclick="showProject('third')">
					<span>실패한 프로젝트 목록</span> <span class="menu-arrow">></span>
				</div>
			</div>

			<div class="content">
				<c:choose>
					<c:when test="${menu eq 'first' }">
						<div id="project_approval" class="content-section">
							<h2>프로젝트 승인 목록</h2>
							<hr class="thick-line">
							<section>
								<form action="/administratorOk.do" method="get"
									id="project-list">
									<input type="hidden" name="cpage" value="1">
									<table class="table custom-table">
										<thead>
											<tr>
												<th>프로젝트명</th>
												<th>프로젝트 등록일</th>
												<th>창작자 이름</th>
												<th></th>

											</tr>

											<tr>
												<td colspan="4"><hr class="thick-line"></td>
											</tr>
										</thead>

										<tbody>
											<c:choose>
												<c:when test="${empty list}">
													<tr>
														<td colspan="5" class="text-center">프로젝트 목록이 없습니다.</td>
													</tr>
												</c:when>
												<c:otherwise>
													<c:forEach var="item" items="${list }">
														<tr>
															<td>${item.projectName }</td>
															<td>${item.projectRegisterDate }</td>
															<td>${item.projectManagerName }</td>
															<td>
																<button type="button" class="approval-button"
																	onclick="projectDetail('${item.projectNo}')">프로젝트
																	상세보기</button>
															</td>
														</tr>
														<tr>
															<td colspan="4"><hr class="thin-line"></td>
														</tr>
													</c:forEach>
												</c:otherwise>
											</c:choose>

										</tbody>
									</table>

									<nav aria-label="Page navigation example">
										<ul class="pagination">
											<c:choose>
												<c:when test="${pi.currentPage == 1 && pi.maxPage > 0}">
													<li class="page-item disabled"><a class="page-link"
														href="#" aria-label="Previous"> <span
															aria-hidden="true">&laquo;</span>
													</a></li>
												</c:when>
												<c:when test="${pi.maxPage > 0 }">
													<li class="page-item"><a class="page-link"
														href="/administratorOk.do?menu=first&cpage=${pi.currentPage-1 }"
														aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
													</a></li>
												</c:when>
											</c:choose>

											<c:forEach var="page" begin="${pi.startPage }"
												end="${pi.endPage }">
												<li class="page-item"><a class="page-link"
													href="/administratorOk.do?menu=first&cpage=${page}">${page}</a></li>

											</c:forEach>

											<c:choose>

												<c:when test="${pi.currentPage == pi.maxPage}">
													<li class="page-item disabled"><a class="page-link"
														href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:when>
												<c:when test="${pi.maxPage > 0 }">
													<li class="page-item"><a class="page-link"
														href="/administratorOk.do?menu=first&cpage=${pi.currentPage+1 }"
														aria-label="Next"> <span aria-hidden="true">&raquo;</span>
													</a></li>
												</c:when>
											</c:choose>
										</ul>
									</nav>
								</form>
							</section>
							<!--  -->
						</div>
					</c:when>
					<c:when test="${menu eq 'second' }">
						<div id="faproject_completedq" class="content-section">
							<h2>완료된 프로젝트 목록</h2>
							<hr class="thick-line">
							<!--  -->
							<form id="project-success">
								<input type="hidden" name="status" value="success">
								<table class="table">
									<thead>
										<tr>


											<th>프로젝트명</th>
											<th>프로젝트 등록일</th>
											<th>프로젝트 종료일</th>
											<th>프로젝트 달성률</th>
											<th></th>


										</tr>
										<tr>
											<td colspan="6"><hr class="thick-line"></td>
										</tr>

									</thead>
									<tbody>
										<c:choose>
											<c:when test="${empty list}">
												<tr>

													<td colspan="6" class="text-center"
														style="text-align: center;">프로젝트 목록이 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="item" items="${list}">
													<input type="hidden" name="project-no"
														value="${item.projectNo}">
														<input type="hidden" id="mailApiKey" name="google-api-secret-key" value="">
										
													<tr style="text-align: center">

														<td>${item.projectName}</td>
														<td>${item.projectRegisterDate}</td>
														<td>${item.projectEndDate}</td>
														<td>${item.projectCurrentPercentage}</td>
														<td><button class="approval-button"
																onclick="successfulProject()">완료 알림</button></td>
													</tr>
													<tr>
														<td colspan="6"><hr class="thin-line"></td>
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
												<li class="page-item disabled"><a class="page-link"
													href="#" aria-label="Previous"> <span
														aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
											<c:when test="${pi.maxPage > 0 }">
												<li class="page-item"><a class="page-link"
													href="/administratorOk.do?menu=second&cpage=${pi.currentPage-1 }"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
										</c:choose>

										<c:forEach var="page" begin="${pi.startPage }"
											end="${pi.endPage }">
											<li class="page-item"><a class="page-link"
												href="/administratorOk.do?menu=second&cpage=${page }">${page}</a></li>
										</c:forEach>

										<c:choose>

											<c:when test="${pi.currentPage == pi.maxPage}">
												<li class="page-item disabled"><a class="page-link"
													href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
											<c:when test="${pi.maxPage > 0 }">
												<li class="page-item"><a class="page-link"
													href="/administratorOk.do?menu=second&cpage=${pi.currentPage+1 }"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
										</c:choose>
									</ul>
								</nav>
							</form>
							<!--  -->
						</div>
					</c:when>
					<c:when test="${menu eq 'third' }">
						<div id="project_failure" class="content-section">
							<h2>실패한 프로젝트 목록</h2>
							<hr class="thick-line">
							<!--  -->
							<form id="project-fail">
								<input type="hidden" name="status" value="fail">
								<table class="table">
									<thead>
										<tr>


											<th>프로젝트명</th>
											<th>프로젝트 등록일</th>
											<th>프로젝트 종료일</th>
											<th>프로젝트 달성률</th>
											<th></th>


										</tr>
										<tr>
											<td colspan="6"><hr class="thick-line"></td>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${empty list}">
												<tr>
													<td colspan="6" class="text-center"><hr
															class="thick-line">프로젝트 목록이 없습니다.</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach var="item" items="${list}">
													<input type="hidden" name="project-no"
														value="${item.projectNo}">

													<tr style="text-align: center">

														<td>${item.projectName}</td>
														<td>${item.projectRegisterDate}</td>
														<td>${item.projectEndDate}</td>
														<td>${item.projectCurrentPercentage}</td>
														<td><button class="approval-button"
																onclick="failedProject()">실패 알림</button></td>
													</tr>
													<tr>
														<td colspan="6"><hr class="thin-line"></td>
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
												<li class="page-item disabled"><a class="page-link"
													href="#" aria-label="Previous"> <span
														aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
											<c:when test="${pi.maxPage > 0 }">
												<li class="page-item"><a class="page-link"
													href="/administratorOk.do?menu=third&cpage=${pi.currentPage-1 }"
													aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
												</a></li>
											</c:when>
										</c:choose>

										<c:forEach var="page" begin="${pi.startPage }"
											end="${pi.endPage }">
											<li class="page-item"><a class="page-link"
												href="/administratorOk.do?menu=third&cpage=${page}">${page}</a></li>
										</c:forEach>

										<c:choose>

											<c:when test="${pi.currentPage == pi.maxPage}">
												<li class="page-item disabled"><a class="page-link"
													href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
											<c:when test="${pi.maxPage > 0 }">
												<li class="page-item"><a class="page-link"
													href="/administratorOk.do?menu=third&cpage=${pi.currentPage+1 }"
													aria-label="Next"> <span aria-hidden="true">&raquo;</span>
												</a></li>
											</c:when>
										</c:choose>
									</ul>
								</nav>
							</form>
							<!—  —>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
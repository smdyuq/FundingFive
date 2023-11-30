<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="../../views/common/head.jsp"%>
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
	<main>
		<section>
			<form id="project-administratorok-form">
				<input type="hidden" name="cpage" value="1">
				<h2>프로젝트 승인 목록</h2>
				<hr>
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
							<c:when test="${empty list }">
								<tr>
									<td colspan="5" class="text-center">등록된 프로젝트가 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list }">
									<tr onclick="projectDetail(${item.projectNo})">
										<td>${item.projectName }</td>
										<td>${item.projectRegisterDate }</td>
										<td>${item.managerName }</td>
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
								href="/administratorOk.do?cpage=${page }">${page }</a></li>
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
	</main>
	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
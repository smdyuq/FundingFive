<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@include file="/views/common/head.jsp"%>
</head>
<body>

	<%@include file="/views/common/header.jsp"%>
	<%@include file="/views/common/nav.jsp"%>
  	<main class="flex-shrink-0">
		<div class="container">
			<h3>
				게시판
				</h2>
				<hr>
				<br />
				<table class="table table-hover">
					<thead>
						<tr>
							<td>선택</td>
							<td>번호</td>
							<td>제목</td>
							<td>작성자(회원번호)</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="">
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list }">
									<tr onclick="detailPage(${item.idx})">
										<td>선택</td>
										<td>${row}</td>
										<td>${item.title }</td>
										<td>${item.writer }</td>
										<td>${item.inDate }</td>
										<td>${item.views }</td>
									</tr>
									<c:set var="row" value="${row-1 }" />
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</tbody>
					<div class="d-grid gap-2d-md-flex justify-content-end float-right ">

						<c:if test="${!empty sessionScope.no}">
							<!-- 글쓰기 버튼은 로그인한 사용자만 보여야 합니다. -->
							<button class="btn btn-dark me-md-2" type="button"
								onclick="window.location.href= '/Enroll.do'">글쓰기</button>
						</c:if>
					</div>
				</table>


				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:choose>
							<c:when test="${pi.currentPage == 1 }">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="/boardList.do?cpage=${pi.currentPage-1 }"
									aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>

						<c:forEach var="page" begin="${pi.startPage }"
							end="${pi.endPage }">
							<li class="page-item"><a class="page-link"
								href="/boardList.do?cpage=${page}">${page}</a></li>
						</c:forEach>


						<c:choose>
							<c:when test="${pi.currentPage == pi.maxPage }">
								<li class="page-item"><a class="page-link" href="#"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="/boardList.do?cpage=${info.currentPage+1 }"
									aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</nav>
		</div>
	</main>
	<%@include file="/views/common/footer.jsp"%>
</body>
</html>
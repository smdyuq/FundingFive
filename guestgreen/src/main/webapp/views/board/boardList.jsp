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
	<main>
		<section>
			<div class="table-container">
				<form action="/boardList.do" method="get">
					<input type="hidden" name="cpage" value="1"> <input
						type="search" name="searchText" placeholder="검색어를 입력하세요">
					<button type="submit">검색</button>
				</form>
				<table class="table table-hover" id="content">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>주회수</th>
						</tr>
					</thead>
					<tbody class="table-group-divider" id="table-content">

						<c:choose>
							<c:when test="${empty list }">
								<tr>
									<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="item" items="${list }">
									<tr onclick="detailPage(${item.idx})">
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
				</table>
				<div class="d-grid gap-2d-md-flex justify-content-end float-right ">

					<c:if test="${sessionScope.userType == 0}">
						<!-- 글쓰기 버튼은 로그인한 사용자만 보여야 합니다. -->
						<button class="btn btn-dark me-md-2" type="button"
							onclick="window.location.href= '/views/board/boardEnroll.jsp'">공지사항
							등록</button>
					</c:if>
					</form>
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
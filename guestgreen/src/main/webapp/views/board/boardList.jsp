<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>

<!-- 부트스트랩 5 CSS 파일 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- 부트스트랩 5 JavaScript 및 팝퍼 라이브러리 -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/css/member/member.css">
<script type="text/javascript" src="/resources/js/board/board.js"></script>

</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>



	<main>


		<div class="a">
			<nav>
				<div class="nav nav-tabs" id="nav-tab" role="tablist">
					<button class="nav-link active" id="information-label"
						data-bs-toggle="tab" data-bs-target="#nav-boardList" type="button"
						role="tab" aria-controls="nav-boardList" aria-selected="true">공지</button>
					<button class="nav-link" id="sponsorship-label"
						data-bs-toggle="tab" data-bs-target="#nav-QnA" type="button"
						role="tab" aria-controls="nav-QnA" aria-selected="false">자주 묻는 질문</button>
				</div>
			</nav>
			<div class="tab-content">
				<div class="tab-pane fade show active" id="nav-boardList"
					role="tabpanel" aria-labelledby="nav-boardList-tab">
					<table class="table table-hover">
						<thead>
							<h2>공지 게시판</h2>
							<tr>
								<!-- <th>글번호</th> -->
								<th style="text-align: left;">제목</th>
								<th style="text-align: center; width: 120px;">작성자</th>
								<th style="text-align: center; width: 120px;">작성일</th>
								<th style="text-align: center; width: 120px;">조회수</th>
								<!-- <th>조회수</th> -->
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
											<!-- <td>${row}</td> -->
											<td style="text-align: left;">${item.title }</td>
											<td style="text-align: center; width: 120px;">관리자</td>
											<td style="text-align: center; width: 120px;">${item.inDate }</td>
											<td style="text-align: center; width: 120px;">${item.views }</td>
											<!-- <td>${item.views }</td> -->
										</tr>
										<c:set var="row" value="${row-1 }" />
									</c:forEach>
								</c:otherwise>
							</c:choose>
	
						</tbody>
					</table>
	
					<div class="d-grid gap-2d-md-flex justify-content-end float-right ">
	
						<c:if test="${memberDTO.memberType == 0}">
							<!-- 멤버 넘버가 1인 사람만 버튼이 보임. -->
							<button class="btn btn-dark me-md-2" type="button"
								onclick="window.location.href= '/views/board/boardEnroll.jsp'">공지사항
								등록</button>
						</c:if>
						<form action="/boardList.do" method="get">
							<input type="hidden" name="cpage" value="1"> <input
								type="search" name="searchText" placeholder="검색어를 입력하세요">
							<button type="submit">검색</button>
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
	
	
							<c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
								<c:choose>
									<c:when test="${page == pi.currentPage}">
										<li class="page-item active"><a class="page-link"
											href="/boardList.do?cpage=${page}">${page}</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/boardList.do?cpage=${page}">${page}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
	
	
							<c:choose>
								<c:when test="${pi.currentPage == pi.maxPage }">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="/boardList.do?cpage=${pi.currentPage+1 }"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
									</a></li>
								</c:otherwise>
							</c:choose>
						</ul>
					</nav>
				</div>
				<div class="tab-pane fade" id="nav-QnA" role="tabpanel"
					aria-labelledby="nav-QnA-tab">
					<details>
						<summary>[회원탈퇴] 회원 탈퇴는 어떻게 하나요?</summary>
						<span># 회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다. 탈퇴 시 회원 전용 웹 서비스 이용이 불가합니다.<br>
						탈퇴 전 유의사항을 반드시 확인해 주시기 바랍니다.<br>	
						[회원 탈퇴하기]
						마이페이지 - 탈퇴하기</span>
					</details>
					<details>
						<summary>[문의]문의관련해서는 어디서 확인해야하나요?</summary>
						<span># 페이지 내 카카오 문의하기를 운영하고 있습니다.<br>
						자세한 문의 사항은 상담원 문의 하기로 문의 부탁드리겠습니다.</span>
					</details>
					<details>
						<summary>[문의]문의관련해서는 어디서 확인해야하나요?</summary>
						<span># 페이지 내 카카오 문의하기를 운영하고 있습니다.<br>
						자세한 문의 사항은 상담원 문의 하기로 문의 부탁드리겠습니다.</span>
					</details>
					
				</div>
			</div>
		</div>


	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>


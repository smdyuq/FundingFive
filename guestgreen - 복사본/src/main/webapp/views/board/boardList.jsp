<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>

<link rel="stylesheet" href="/resources/css/board/boardList.css">
<script type="text/javascript" src="/resources/js/board/board.js"></script>
<style>


.pagination {
	display: flex;
	justify-content: center;
	align-items: center;
	list-style: none;
	padding: 0;
}

.page-item {
	margin: 0 5px;
}

.page-link {
	color: black;
	text-decoration: none;
	padding: 5px 10px;
	border: 1px solid black;
	border-radius: 5px;
}

.page-link:hover {
	background-color: lightgray;
}

.page-link.disabled {
	color: gray;
	pointer-events: none;
}

</style>


</head>
<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>



	<main>
		<div class="container">
			<div class="menu-container">
				<h2>고객센터</h2>
				<div class="menu" onclick="showContent('notice')">
					<span>공지사항</span> <span class="menu-arrow"></span>
				</div>
				<div class="menu" onclick="showContent('faq')">
					<span>자주하는 질문</span> <span class="menu-arrow">></span>
				</div>
			</div>

			<div class="content">
				<div id="notice" class="content-section">
					<h2>공지사항</h2>
					<hr class="thick-line">
					<table class="table table-hover">
						<thead>
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

					<div class="board_btn_div">

						<form action="/boardList.do" method="get">
							<input type="hidden" name="cpage" value="1"> <input
								type="search" name="searchText" placeholder="검색어를 입력하세요">
							<button type="submit">검색</button>
						</form>
						<c:if test="${sessionScope.memberType == 0}">
							<!-- 멤버 타입 0인 사람만 버튼이 보임. -->
							<button class="notice_registration_btn" type="button"
								onclick="window.location.href= '/views/board/boardEnroll.jsp'">공지사항
								등록</button>
						</c:if>
					</div>



					<!-- 페이지네이션 -->
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:choose>
								<c:when test="${pi.currentPage == 1 }">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
									</a></li>
								</c:when>

								<c:otherwise>
									<div class="page-item">
										<a class="page-link"
											href="/boardList.do?cpage=${pi.currentPage-1 }"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a>
									</div>
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


				<div id="faq" class="content-section" style="display: none;">
					<h2>자주 묻는 질문</h2>
					<hr class="thick-line">
					<div class="faq-item">
						<div class="faq-title">
							<a class="text_q">Q. &nbsp;</a> [회원탈퇴] 회원 탈퇴는 어떻게 하나요?
						</div>
						<div class="faq-content">
							회원 탈퇴는 아래의 절차를 따라 하실 수 있습니다. 탈퇴 시 회원 전용 웹 서비스 이용이 불가합니다.<br>
							탈퇴 전 유의사항을 반드시 확인해 주시기 바랍니다.<br> [회원 탈퇴하기] 마이페이지 - 탈퇴하기
						</div>
						<hr class="thin-line_gray">
					</div>
					<div class="faq-item">
						<div class="faq-title">
							<a class="text_q">Q. &nbsp;</a>[문의]문의관련해서는 어디서 확인해야하나요?
						</div>
						<div class="faq-content">
							페이지 내 카카오 문의하기를 운영하고 있습니다.<br> 자세한 문의 사항은 상담원 문의 하기로 문의
							부탁드리겠습니다.
						</div>
						<hr class="thin-line_gray">
					</div>
					<div class="faq-item">
						<div class="faq-title">
							<a class="text_q">Q. &nbsp;</a> [문의]문의관련해서는 어디서 확인해야하나요?
						</div>
						<div class="faq-content">
							페이지 내 카카오 문의하기를 운영하고 있습니다.<br> 자세한 문의 사항은 상담원 문의 하기로 문의
							부탁드리겠습니다.
						</div>

						<hr class="thin-line_gray">
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>

</html>
<script>
    // 좌측 메뉴
    function showContent(id) {
        var sections = document.getElementsByClassName('content-section');
        for (var i = 0; i < sections.length; i++) {
            sections[i].style.display = 'none';
        }
        document.getElementById(id).style.display = 'block';

        var menus = document.getElementsByClassName('menu');
        for (var i = 0; i < menus.length; i++) {
            menus[i].classList.remove('active');
        }
        document.querySelector('.menu[onclick="showContent(\'' + id + '\')"]').classList.add('active');
    }

    window.onload = function () {
        // 페이지 로드 시 '공지사항' 메뉴의 내용을 보여줌
        showContent('notice');

        var faqItems = document.querySelectorAll('.faq-item');

        faqItems.forEach(function (item) {
            var title = item.querySelector('.faq-title');
            var content = item.querySelector('.faq-content');

            title.addEventListener('click', function () {
                var display = content.style.display;
                content.style.display = (display === 'block') ? 'none' : 'block';

            });



        });
    };
</script>

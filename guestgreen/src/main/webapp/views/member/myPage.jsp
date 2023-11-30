<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/member.css">
<script src="/resources/js/member/myPage.js"></script>

<style>
main {
	padding: 10px;
}
</style>
</head>

<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>

	<main onload="showTabContent('information');">
		<div class="information-div">
			<h2>마이 페이지</h2>

			<div class="tabs">
				<input id="information" type="radio" name="tab_item" checked
					onchange="showTabContent('information')"> <label
					class="tab_item" for="information">내 정보</label> <input
					id="sponsorship" type="radio" name="tab_item"
					onchange="showTabContent('sponsorship')"> <label
					class="tab_item" for="sponsorship">후원</label> <input id="project"
					type="radio" name="tab_item" onchange="showTabContent('project')">
				<label class="tab_item" for="project">프로젝트</label>
			</div>

			<div class="tab_content" id="information_content">
				<div class="member-information-div">
					<form id="update-form" action="/update.do" method="post">
						<div class="signup-input">
							<label for="member-id">아이디</label> <input type="text"
								id="member-id" name="member-id" onkeyup="duplicateId()"
								value="${memberDTO.memberId}" required><br> <span id="idMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-pwd">비밀번호 </label> <input type="password"
								id="member-pwd" name="member-pwd" onkeyup="validatePassword()"
								placeholder="******" readonly> <br> <span
								id="passwordMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-name">이름 </label> <input type="text"
								id="member-name" name="member-name" onkeyup="validateName() "
								value="${memberDTO.memberName}" required><br> <span
								id="nameMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-phone">휴대폰 번호:</label> <input type="number"
								value="${memberDTO.memberPhone}" id="member-phone" name="member-phone"
								onkeyup="" required><br> <span id="phonekMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-addr">주소</label> <input type="text"
								value="${memberDTO.memberAddr}" id="member-addr" name="member-addr"
								onkeyup="" required><br> <span id="addrMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-createDate">가입일</label> <input type="text"
								value="${memberDTO.memberCreateDate}" id="member-createDate" name="member-createDate	>							onkeyup="" readonly><br> <span id="addrMsg"></span>
						</div>
						<br>
						<div class="signup-input">
							<label for="member-updateDate">최종 수정일</label> <input type="text"
								value="${memberDTO.memberUpdateDate}" id="member-updateDate" name="member-updateDate	>							onkeyup="" readonly><br> <span id="addrMsg"></span>
						</div>
						<br>
						<button type="submit">수정하기</button>
						<button type="submit" onclick="deleteBtn()">탈퇴하기</button>
					</form>
				</div>
			</div>


			<div class="tab_content" id="sponsorship_content">

				<div class="support-div1">
					<p>여기는 후원 승인유무</p>
					<table class="project-table">
						<thead class="project-thead">
							<tr>
								<th>프로젝트 이미지</th>
								<th>프로젝트명</th>
								<th>카테고리명</th>
								<th>프로젝트 설명</th>
								<th>후원 현황</th>
								<th>생성일</th>
								<th>마감일</th>
							</tr>
						</thead>
						<tbody class="project-tbody">
							<tr>
								<td>이미지</td>
								<td>명</td>
								<td>카테고리명</td>
								<td>설명</td>
								<td>현황</td>
								<td>생성일</td>
								<td>마감일</td>
							</tr>
							<tr>
								<td>이미지</td>
								<td>명</td>
								<td>카테고리명</td>
								<td>설명</td>
								<td>현황</td>
								<td>생성일</td>
								<td>마감일</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div>
			<div class="tab_content" id="project_content">
				<div class="project-div1">
					<p>여기는 프로젝트 승인유무 Y</p>
					<div class="table-container">
						<form action="/projectList.do" method="GET">
							<input type="hidden" name="cpage" value=1> <input
								type="search" name="searchText" placeholder="프로젝트명을 입력해주세요.">
							<button type="submit">검색</button>
						</form>

						<table class="project-table table table-hover" id="content">
							<thead class="project-thead">
								<tr>
									<th>프로젝트 이미지</th>
									<th>프로젝트명</th>
									<th>카테고리명</th>
									<th>프로젝트 설명</th>
									<th>후원 현황</th>
									<th>생성일</th>
									<th>마감일</th>
								</tr>
							</thead>
							<tbody class="project-tbody">
								<c:choose>
									<c:when test="${empty projectApprovedList}">
										<tr>
											<td colspan="7" class="text-center">등록된 프로젝트가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="project" items="${projectApprovedList}">
											<tr>
												<th>${project.projectOuterImageName}</th>
												<th>${project.projectIntroduce}</th>
												<th>${project.projectKind}</th>
												<th>${project.projectKind}</th>
												<th>${project.projectCurrentAmount}</th>
												<th>${project.projectRegisterDate}</th>
												<th>${project.projectEndDate}</th>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:choose>
									<c:when test="${pi.currentPage == 1}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/projectList.do?cpage=${pi.currentPage-1}&searchText=${searchText}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach var="page" begin="${pi.startPage}"
									end="${pi.endPage}">
									<li class="page-item"><a class="page-link"
										href="/projectList.do?cpage=${page}&searchText=${searchText}">${page}</a></li>
								</c:forEach>
								<c:choose>
									<c:when test="${pi.currentPage == pi.maxPage}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/projectList.do?cpage=${pi.currentPage+1}&searchText=${searchText}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>


				<div class="project-div2">
					<p>여기는 프로젝트 승인유무 C</p>
					<div class="table-container">
						<form action="/projectList.do" method="GET">
							<input type="hidden" name="cpage" value=1> <input
								type="search" name="searchText" placeholder="프로젝트명을 입력해주세요.">
							<button type="submit">검색</button>
						</form>
						<table class="project-table table table-hover" id="content">
							<thead class="project-thead">
								<tr>
									<th>프로젝트 이미지</th>
									<th>프로젝트명</th>
									<th>카테고리명</th>
									<th>프로젝트 설명</th>
									<th>후원 현황</th>
									<th>생성일</th>
									<th>마감일</th>
								</tr>
							</thead>
							<tbody class="project-tbody">
								<c:choose>
									<c:when test="${empty projectRejectedList}">
										<tr>
											<td colspan="7" class="text-center">등록된 프로젝트가 없습니다.</td>
										</tr>
									</c:when>
									<c:otherwise>
										<c:forEach var="project" items="${projectRejectedList}">
											<tr>
												<th>프로젝트 이미지</th>
												<th>프로젝트명</th>
												<th>카테고리명</th>
												<th>프로젝트 설명</th>
												<th>후원 현황</th>
												<th>생성일</th>
												<th>마감일</th>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<c:choose>
									<c:when test="${pi.currentPage == 1}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/projectList.do?cpage=${pi.currentPage-1}&searchText=${searchText}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
								<c:forEach var="page" begin="${pi.startPage}"
									end="${pi.endPage}">
									<li class="page-item"><a class="page-link"
										href="/projectList.do?cpage=${page}&searchText=${searchText}">${page}</a></li>
								</c:forEach>
								<c:choose>
									<c:when test="${pi.currentPage == pi.maxPage}">
										<li class="page-item"><a class="page-link" href="#"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item"><a class="page-link"
											href="/projectList.do?cpage=${pi.currentPage+1}&searchText=${searchText}"
											aria-label="Next"> <span aria-hidden="true">&raquo;</span>
										</a></li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/member.css">
<script src="/resources/js/member/myPage.js"></script>
<script src="/resources/js/project/apiKey.js"></script>
<style>
main {
	padding: 10px;
}
</style>
</head>

<body>
	<%@include file="../../views/common/header.jsp"%>
	<%@include file="../../views/common/nav.jsp"%>
	<%@include file="../../views/common/common.jsp"%>

	<main onload="showTabContent('information');">
		<div class="container">
			<div class="menu-container">
				<h2>마이페이지</h2>
				<div class="menu" onclick="showContent('information')">
					<span>내정보</span> <span class="menu-arrow">></span>
				</div>
				<div class="menu" onclick="showContent('sponsorship')">
					<span>후원 현황</span> <span class="menu-arrow">></span>
				</div>
				<div class="menu" onclick="showContent('project_status')">
					<span>프로젝트 현황</span> <span class="menu-arrow">></span>
				</div>
				<div class="menu" onclick="showContent('shipping_information')">
					<span>배송정보</span> <span class="menu-arrow">></span>
				</div>
			</div>

			<!-- 내정보 -->
			<div class="content">
				<div id="information" class="content-section">
					<h2>내정보</h2>
					<hr class="thick-line">
					<div class="member-information-div">
						<form id="update-form" action="/update.do" method="post">
							<div class="signup-input">
								<label for="member-id">아이디</label> <input type="text"
									id="member-id" name="member-id" onkeyup="duplicateId()"
									value="${memberDTO.memberId}" required><br> <span
									id="idMsg"></span>
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
								<label for="member-phone">휴대폰 번호</label> <input type="number"
									value="${memberDTO.memberPhone}" id="member-phone"
									name="member-phone" onkeyup="" required><br> <span
									id="phonekMsg"></span>
							</div>
							<br>
							<div class="signup-input">
								<label for="member-addr">주소</label> <input type="text"
									value="${memberDTO.memberAddr}" id="member-addr"
									name="member-addr" onkeyup="" required><br> <span
									id="addrMsg"></span>
							</div>
							<br>
							<div class="signup-input">
								<label for="member-createDate">가입일</label> <input type="text"
									value="${memberDTO.memberCreateDate}" id="member-createDate"
									name="member-createDate" onkeyup="" readonly><br>
								<span id="addrMsg"></span>
							</div>
							<br>
							<div class="signup-input">
								<label for="member-updateDate">최종 수정일</label> <input type="text"
									value="${memberDTO.memberUpdateDate}" id="member-updateDate"
									name="member-updateDate" onkeyup="" readonly><br>
								<span id="addrMsg"></span>
							</div>
							<br>
							<button type="submit">수정하기</button>
							<button type="submit" onclick="deleteBtn()">탈퇴하기</button>
						</form>
					</div>
				</div>



				<!-- 후원현황 -->
				<div id="sponsorship" class="content-section" style="display: none;">
					<h2>후원현황</h2>
					<hr class="thick-line">
					<div class="support-div1">
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
							<c:choose>
								<c:when test="">
									<div class="sponsorship_result_n">
										<p>후원현황이 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<tbody class="sponsorship_result">
										<c:forEach var="searching" items="">
											<tr class="sponsorship_result_tr">
												<td>이미지</td>
												<td>프로젝트명</td>
												<td>카테고리명</td>
												<td>설명</td>
												<td>현황</td>
												<td>생성일</td>
												<td>마감일</td>
											</tr>
										</c:forEach>
									</tbody>
								</c:otherwise>
							</c:choose>
						</table>
					</div>
				</div>

				<!-- 프로젝트 -->
				<div id="project_status" class="content-section"
					style="display: none;">
					<h2>프로젝트</h2>
					<hr class="thick-line">
					<div class="project-div1">
						<p>승인된 프로젝트</p>
						<div class="table-container">

							<table class="project-table" id="content">
								<thead class="project-thead">
									<tr>
										<th>프로젝트 이미지</th>
										<th>프로젝트명</th>
										<th>카테고리명</th>
										<th>프로젝트 설명</th>
										<th>프로젝트 가격</th>
										<th>프로젝트 목표 후원금액</th>
										<th>후원 현황</th>
										<th>생성일</th>
										<th>마감일</th>
										<th>프로젝트 판매유무</th>
									</tr>
								</thead>
								<tbody class="project-tbody">
									<c:choose>
										<c:when test="${empty projectApprovedList}">
											<tr>
												<td colspan="7" class="text-center">승인된 프로젝트가 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="project" items="${projectApprovedList}">
												<tr>
													<th>${project.projectOuterImageName}</th>
													<th>${project.projectIntroduce}</th>
													<th>${project.projectKind}</th>
													<th>${project.projectKind}</th>
													<th>프로젝트 가격</th>
													<th>프로젝트 목표 후원금액</th>
													<th>${project.projectCurrentAmount}</th>
													<th>${project.projectRegisterDate}</th>
													<th>${project.projectEndDate}</th>
													<th>프로젝트 판매유무</th>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<hr>
					</div>
					<div class="project-div2">
						<p>승인 대기중인 프로젝트</p>
						<div class="table-container">
							<table class="project-table" id="content">
								<thead class="project-thead">
									<tr>
										<th>프로젝트 이미지</th>
										<th>프로젝트명</th>
										<th>카테고리명</th>
										<th>프로젝트 설명</th>
										<th>프로젝트 가격</th>
										<th>프로젝트 목표 후원금액</th>
										<th>후원 현황</th>
										<th>생성일</th>
										<th>마감일</th>
									</tr>
								</thead>
								<tbody class="project-tbody">
									<c:choose>
										<c:when test="${empty projectPendingList}">
											<tr>
												<td colspan="7" class="text-center">대기중인 프로젝트가 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="project" items="${projectPendingList}">
												<tr>
													<th>프로젝트 이미지</th>
													<th>프로젝트명</th>
													<th>카테고리명</th>
													<th>프로젝트 설명</th>
													<th>프로젝트 가격</th>
													<th>프로젝트 목표 후원금액</th>
													<th>후원 현황</th>
													<th>생성일</th>
													<th>마감일</th>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
						<hr>
					</div>
					<div class="project-div3">
						<p>승인 거절된 프로젝트</p>
						<div class="table-container">
							<table class="project-table" id="content">
								<thead class="project-thead">
									<tr>
										<th>프로젝트 이미지</th>
										<th>프로젝트명</th>
										<th>카테고리명</th>
										<th>프로젝트 설명</th>
										<th>프로젝트 가격</th>
										<th>프로젝트 목표 후원금액</th>
										<th>생성일</th>
										<th>마감일</th>
										<th>거절사유</th>
									</tr>
								</thead>
								<tbody class="project-tbody">
									<c:choose>
										<c:when test="${empty projectRejectedList}">
											<tr>
												<td colspan="7" class="text-center">승인 거절된 프로젝트가 없습니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<c:forEach var="project" items="${projectRejectedList}">
												<tr>
													<th>프로젝트 이미지</th>
													<th>프로젝트명</th>
													<th>카테고리명</th>
													<th>프로젝트 설명</th>
													<th>프로젝트 가격</th>
													<th>프로젝트 목표 후원금액</th>
													<th>생성일</th>
													<th>마감일</th>
													<th>거절사유</th>
												</tr>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<!-- 배송조회 -->
				<div id="shipping_information" class="content-section"
					style="display: none;">
					<h2>배송조회</h2>
					<div class="table-container">
						<form action="http://info.sweettracker.co.kr/tracking/3"
							method="post">
							<div class="form-group">
								<input type="hidden" class="form-control" id="t_key"
									name="t_key">
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control" name="t_code"
									id="t_code" value="04">
							</div>
							<div class="form-group">
								<label for="t_invoice">운송장 번호</label> <input type="text"
									class="form-control" name="t_invoice" id="t_invoice"
									placeholder="운송장 번호">
							</div>
							<button type="submit" class="btn btn-default">조회하기</button>
						</form>
					</div>
				</div>




			</div>
		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>

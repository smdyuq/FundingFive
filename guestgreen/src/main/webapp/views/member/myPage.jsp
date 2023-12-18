<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../views/common/head.jsp"%>
<link rel="stylesheet" href="/resources/css/member/member.css">
<script src="/resources/js/project/projectDetail.js"></script>
<script src="/resources/js/project/apiKey.js"></script>
<script src="/resources/js/member/myPage.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style>
main {
	padding: 10px;
}

.form-control {
	display: flex;
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
				<div class="menu" onclick="showContent('like_project')">
					<span>관심있는 프로젝트</span> <span class="menu-arrow">></span>
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
						<c:choose>
							<c:when test="${empty memberDonateList}">
								<div class="project_status_result_n">
									<p>후원현황이 없습니다.</p>
								</div>			
							</c:when>
							<c:otherwise>
								<div class="sponsorship_result_div">
									<c:forEach var="item" items="${memberDonateList}"
										varStatus="status">
										<div class="item-container">
											<!-- 추가된 부분 -->
											<div class="sponsorship_project_div">
												<div class="project_info">
													<!-- 추가된 부분 -->
													<div class="image-container">
														<img class="sponsorship_img"
															src="/resources/uploads/outerimage/300x300/${item.projectOuterImageName}"
															alt="프로젝트 이미지">
													</div>
													<div class="info-container">
														<div class="info-set">
															<span class="sponsorship_title">카테고리명: </span> <span
																class="value">${item.projectKind}</span>
														</div>
														<div class="info-set">
															<span class="sponsorship_title">프로젝트 명: </span> <span
																class="value">${item.projectName }</span>
														</div>
														<div class="info-set">
															<span class="sponsorship_title">프로젝트 설명: </span> <span
																class="value">${item.projectIntroduce }</span>
														</div>
														<div class="info-set">
															<span class="sponsorship_title">생성일: </span> <span
																class="value">${item.projectRegisterDate }</span>
														</div>
														<div class="info-set">
															<span class="sponsorship_title">마감일: </span> <span
																class="value">${item.projectEndDate }</span>
														</div>
													</div>
												</div>
												<hr>
											</div>
										</div>
									</c:forEach>
									<div class="button_container">
										<button class="moreBtn">더보기</button>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>


				<!-- 프로젝트 -->
				<div id="project_status" class="content-section"
					style="display: none;">
					<h2>프로젝트 현황</h2>
					<hr class="thick-line">
					<div class="project-div1">
						<p>승인된 프로젝트</p>
						<div class="table-container">
							<c:choose>
								<c:when test="${empty projectApprovedList}">
									<div class="project_status_result_n">
										<p>승인된 프로젝트가 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<div class="sponsorship_result_div">
										<c:forEach var="project" items="${projectApprovedList}"
											varStatus="status">
											<div class="item-container1">
												<div class="sponsorship_project_div">
													<div class="project_info">
														<div class="image-container">
															<img class="sponsorship_img"
																src="/resources/uploads/outerimage/300x300/${project.projectOuterImageName}"
																alt="프로젝트 이미지">
														</div>
														<div class="info-container">
															<div class="info-set">
																<span class="sponsorship_title">카테고리명: </span> <span
																	class="value">${project.projectKind}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 명: </span> <span
																	class="value">${project.projectName}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 설명: </span> <span
																	class="value">${project.projectIntroduce }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 가격: </span> <span
																	class="value">${project.projectPrice }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">생성일: </span> <span
																	class="value">${project.projectRegisterDate }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">마감일: </span> <span
																	class="value">${project.projectEndDate }</span>
															</div>
														</div>
													</div>
													<hr>
												</div>
											</div>

										</c:forEach>
										<div class="button_container">
											<button class="moreBtn1">더보기</button>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>


					<div class="project-div2">
						<p>승인 대기중인 프로젝트</p>
						<div class="table-container">
							<c:choose>
								<c:when test="${empty projectPendingList}">
									<div class="project_status_result_n">
										<p>승인 대기중인 프로젝트가 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<div class="sponsorship_result_div">
										<c:forEach var="project" items="${projectPendingList}"
											varStatus="status">
											<div class="item-container2">
												<div class="sponsorship_project_div">
													<div class="project_info">
														<div class="image-container">
															<img class="sponsorship_img"
																src="/resources/uploads/outerimage/300x300/${project.projectOuterImageName}"
																alt="프로젝트 이미지">
														</div>
														<div class="info-container">
															<div class="info-set">
																<span class="sponsorship_title">카테고리명: </span> <span
																	class="value">${project.projectKind}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 명: </span> <span
																	class="value">${project.projectName}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 설명: </span> <span
																	class="value">${project.projectIntroduce }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 가격: </span> <span
																	class="value">${project.projectPrice }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">생성일: </span> <span
																	class="value">${project.projectRegisterDate }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">마감일: </span> <span
																	class="value">${project.projectEndDate }</span>
															</div>
														</div>
													</div>
													<hr>
												</div>
											</div>
										</c:forEach>
										<div class="button_container">
											<button class="moreBtn2">더보기</button>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>


					<div class="project-div3">
						<p>승인 거절된 프로젝트</p>
						<div class="table-container">
							<c:choose>
								<c:when test="${empty projectRejectedList}">
									<div class="project_status_result_n">
										<p>승인 거절된 프로젝트가 없습니다.</p>
									</div>
								</c:when>
								<c:otherwise>
									<div class="sponsorship_result_div">
										<c:forEach var="project" items="${projectRejectedList}"
											varStatus="status">
											<div class="item-container3">
												<div class="sponsorship_project_div">
													<div class="project_info">
														<div class="image-container">
															<img class="sponsorship_img"
																src="/resources/uploads/outerimage/300x300/${project.projectOuterImageName}"
																alt="프로젝트 이미지">
														</div>
														<div class="info-container">
															<div class="info-set">
																<span class="sponsorship_title">카테고리명: </span> <span
																	class="value">${project.projectKind}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 명: </span> <span
																	class="value">${project.projectName}</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 설명: </span> <span
																	class="value">${project.projectIntroduce }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">프로젝트 가격: </span> <span
																	class="value">${project.projectPrice }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">생성일: </span> <span
																	class="value">${project.projectRegisterDate }</span>
															</div>
															<div class="project_status_info-container">
																<span class="sponsorship_title">마감일: </span> <span
																	class="value">${project.projectEndDate }</span>
															</div>
														</div>
													</div>
													<hr>
												</div>
											</div>
										</c:forEach>
										<div class="button_container">
											<button class="moreBtn3">더보기</button>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>



				<div id="shipping_information" class="content-section"
					style="display: none;">
					<h2>운송장 번호 조회</h2>
					<hr class="thick-line">
					<p style="color: red;">운송장 번호를 조회하여 배송 현황을 확인해보세요.</p>
					<form id="tracking-form"
						onsubmit="event.preventDefault(); openPopup('http://info.sweettracker.co.kr/tracking/3', this.elements.t_invoice.value);">
						<div class="table-container">
							<div class="form-group">
								<input type="hidden" class="form-control" id="t_key"
									name="t_key">
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control" name="t_code"
									id="t_code" value="04">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="t_invoice"
									id="t_invoice" placeholder="운송장 번호를 입력해주세요.">
								<button type="submit" class="btn btn-default">조회하기</button>
							</div>
						</div>
					</form>
				</div>

				<!-- 팝업 모달 -->
				<div id="popup-modal"
					style="display: none; position: fixed; z-index: 1; left: 0; top: 0; width: 100%; height: 100%; overflow: auto; background-color: rgba(0, 0, 0, 0.4);">
					<div
						style="background-color: #fefefe; margin: 15% auto; padding: 20px; border: none; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5); border-radius: 10px; width: 80%;">
						<iframe id="popup-iframe" style="width: 100%; height: 500px;"></iframe>
						<div style="text-align: right;">
							<button onclick="closePopup()">닫기</button>
						</div>
					</div>
				</div>

				<!-- 좋아요 -->
				<div id="like_project" class="content-section"
					style="display: none;">
					<h2>관심있는 프로젝트</h2>
					<hr class="thick-line">
					<div class="table-container">
						<div class="project-cartegory">
							<c:choose>
								<c:when test="${empty memberWishList }">
									<p>관심있는 프로젝트가 없습니다.</p>
								</c:when>
								<c:otherwise>
									<c:forEach var="project" items="${memberWishList}">
										<div class="product_container">
											<div class="product">
												<div class="img_div">
													<a class="img_div_a" href=""><img
														src="/resources/uploads/outerimage/130x105/${project.projectOuterImageName }"
														alt=""></a>
												</div>
												<a href="#" class="category_name">${project.projectKind }</a><a
													class="divide_area">|</a><a href="#" class="manager_name">${project.projectManagerName }</a>
												<a href="#" class="project_title">${project.projectName}
												</a>
												<p class="project_explanation">${project.projectIntroduce }</p>
												<div class="detail_text">
													<p class="achievement_rate">${project.projectCurrentPercentage }%</p>
													<p class="sponsorship_amount">${project.projectCurrentAmount }원</p>
													<p class="remaining_days">${project.projectRemainDate}일
														남음</p>
												</div>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>


			</div>
		</div>
	</main>

	<%@include file="../../views/common/footer.jsp"%>
</body>
</html>
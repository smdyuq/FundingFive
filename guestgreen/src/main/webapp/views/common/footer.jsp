<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <footer>
        <div class="footer_container">
            <div class="footerInfo" data-itemtype="company-info">

                <div class="groupInfo">
                    <p>팀 명:F5 &nbsp 주소:경기도 안양시 만안구 안양로 303 KR 메타포스빌 &nbsp 대표:이승엽 &nbsp 대표번호:031-000-1111 &nbsp 문의:문의 사항은
                        톡 문의하기의 상담원 연결을 이용해주시기 바랍니다.</p>
                    <div>
                        <div class="wrap">
                            <a href="#pop_info_1" class="btn_open">이용 약관</a>

                            <div id="pop_info_1" class="pop_wrap" style="display:none;">
                                <div class="pop_inner">
                                    <p class="dsc">제1절 총칙 제1조 목적 주식회사 백패커(이하 "회사")는 다양한 분야에 걸친 창작 프로젝트들을 통해 창작자와 후원자를
                                        연결하고 있습니다.<br>
                                        </p>
                                    <button type="button" class="btn_close">닫기</button>
                                </div>
                            </div>
                        </div>
                    <div>
                        일부 상품의 경우 [F5]는 통신판매중개자이며 통신판매 당사자가 아닙니다.
                        해당되는 상품의 경우 상품, 상품정보, 거래에 관한 의무와 책임은 판매자에게 있으므로, 각 상품 페이지에서 구체적인 내용을 확인하시기 바랍니다.
                    </div>
                    <p class="InfoRaw">Copyright 2023. [Team] F5. All Rights Reserved.</p>
                </div>              
            </div>
            <div class="footerSns">
                <div class="footerSns_image_div">
                    <div class="sns_image">
                        <a href="https://www.instagram.com/"><img src="./instagram.png"
                                style="width:25px; height:25px;"></a>
                    </div>
                    <div class="sns_image">
                        <a href="https://twitter.com/?lang=ko"><img src="./twitter.png"
                                style="width:25px; height:25px;"></a>
                    </div>
                    <div class="sns_image">
                        <a href="https://www.facebook.com/?locale=ko_KR"><img src="./facebook.png"
                                style="width:25px; height:25px;"></a>
                    </div>
                </div>

                <div class="faq-content">
                    <button class="question" id="que-1"><span id="que-1-toggle">+</span><span>Team] F5
                            팀원소개</span></button>
                    <div class="answer" id="ans-1">팀원: </div>
                </div>
            </div>   
        </div>
        </div>

</footer>
<script>
    const items = document.querySelectorAll('.question');
    
    function openCloseAnswer() {
        const answerId = this.id.replace('que', 'ans');
        const answerElement = document.getElementById(answerId);

        if (answerElement.style.display === 'block') {
            answerElement.style.display = 'none';
            document.getElementById(this.id + '-toggle').textContent = '+';
        } else {
            answerElement.style.display = 'block';
            document.getElementById(this.id + '-toggle').textContent = '-';
            answerElement.scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'nearest' });
        }
    }

    items.forEach(item => item.addEventListener('click', openCloseAnswer));
    
    
    
    
    var target = document.querySelectorAll('.btn_open');
    var btnPopClose = document.querySelectorAll('.pop_wrap .btn_close');
    var targetID;

    // 팝업 열기
    for (var i = 0; i < target.length; i++) {
        target[i].addEventListener('click', function () {
            targetID = this.getAttribute('href');
            document.querySelector(targetID).style.display = 'block';
        });
    }

    // 팝업 닫기
    for (var j = 0; j < target.length; j++) {
        btnPopClose[j].addEventListener('click', function () {
            this.parentNode.parentNode.style.display = 'none';
        });
    }
</script>
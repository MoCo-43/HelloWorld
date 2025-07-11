<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width">
    <title>이벤트 리스너로 장바구니 수량 변경 및 자동 합계 구하기</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
        integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/cart.css" />
</head>

<body>

    <form name="orderform" id="orderform" method="post" class="orderform" action="/Page">

        <input type="hidden" name="cmd" value="order">
        <div class="basketdiv" id="basket">

            <div class="row head">
                <div class="subdiv">
                    <div class="check">선택</div>
                    <div class="img">이미지</div>
                    <div class="pname">상품명</div>
                </div>
                <div class="subdiv">
                    <div class="basketprice">가격</div>
                    <div class="num">수량</div>
                    <div class="sum">합계</div>
                </div>
                <div class="subdiv">
                    <div class="basketcmd">삭제</div>
                </div>
                <div class="split"></div>
            </div>
            <!-- 상품 -->
            <div id="cart-list">
            <div class="row data" data-id="1">
                <div class="subdiv">
                    <div class="check"><input type="checkbox" name="buy" value="260" checked="">&nbsp;</div>
                    <div class="img"><img src="./images/basket1.jpg" width="60"></div>
                    <div class="pname"> <span>찜마마(XJ-92214/3)</span> </div>
                </div>
                <div class="subdiv">
                    <div class="basketprice">
                        <input type="hidden" name="p_price" id="p_price1" class="p_price" value="20000">20,000원
                    </div>
                    <div class="num">
                        <div class="updown">
                            <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value="2"
                                onkeyup="javascript:basket.changePNum();">
                            <span onclick="javascript:basket.changePNum();">
                                <i class="fas fa-arrow-alt-circle-up up"></i> </span>
                            <span onclick="javascript:basket.changePNum();">
                                <i class="fas fa-arrow-alt-circle-down down"></i> </span>
                        </div>
                    </div>
                    <div class="sum">40,000원</div>
                </div>
                <div class="subdiv">
                    <div class="basketcmd">
                        <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem();">삭제</a>
                    </div>
                </div>
            </div>
        </div>
		</div>
        <div class="right-align basketrowcmd">
            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delCheckedItem();">선택상품삭제</a>
            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delAllItem();">장바구니비우기</a>
        </div>

        <div class="bigtext right-align sumcount" id="sum_p_num">상품갯수: <span>4</span>개</div>
        <div class="bigtext right-align box blue summoney" id="sum_p_price">합계금액: <span>74,200</span>원</div>

        <div id="goorder" class="">
            <div class="clear"></div>
            <div class="buttongroup center-align cmd">
                <a href="javascript:void(0);">선택한 상품 주문</a>
            </div>
        </div>
    </form>

    <script type="text/javascript" src="./js/cart.js"></script>
</body>

</html>
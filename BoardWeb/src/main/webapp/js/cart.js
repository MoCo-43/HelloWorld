/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]

// 숫자에 콤마 생성
function numberWithCommas(x) {
  if(!x) return 0;
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

const basket = {
// 장바구니 수량 변경.
updateList() {
    let str = '';
    let list = document.querySelector('#cart-list');
    cartItems.forEach(cart => {
      str += `<div class="row data" data-id="${cart.itemId}">
                <div class="subdiv">
                    <div class="check"><input type="checkbox" name="buy" checked></div>
                    <div class="img"><img src="./images/${cart.image}" width="60"></div>
                    <div class="pname"><span>${cart.itemName}</span></div>
                </div>
                <div class="subdiv">
                    <div class="basketprice">
                        <input type="hidden" class="p_price" value="${cart.price}">
                        ${numberWithCommas(cart.price)}원
                    </div>
                    <div class="num">
                        <div class="updown">
                            <input type="text" class="p_num" value="${cart.qty}"
                                   onkeyup="basket.changePNum()">
                            <span onclick="basket.increaseQty(this)">
                                <i class="fas fa-arrow-alt-circle-up up"></i></span>
                            <span onclick="basket.decreaseQty(this)">
                                <i class="fas fa-arrow-alt-circle-down down"></i></span>
                        </div>
                    </div>
                    <div class="sum">${numberWithCommas(cart.price * cart.qty)}원</div>
                </div>
                <div class="subdiv">
                    <div class="basketcmd">
                        <a href="javascript:void(0)" class="abutton" onclick="basket.delItem();">삭제</a>
                    </div>
                </div>
              </div>`;
    });
    list.innerHTML = str;
    basket.changePNum(); // 새로 만든 항목들에 대해 총합 계산도 다시
  },

	changePNum() {
	const rows = document.querySelectorAll('.row.data');
	const totalQty = 0;
	const totalPrice = 0;

	 rows.forEach(row => {
	 const qty = parseInt(row.querySelector('.p_num').value);
	 const price = parseInt(row.querySelector('.p_price').value);
	 const sum = qty * price;
	      row.querySelector('.sum').innerText = numberWithCommas(sum) + '원';
	      totalQty += qty;
	      totalPrice += sum;
	    });

	    document.querySelector('#sum_p_num span').innerText = totalQty;
	    document.querySelector('#sum_p_price span').innerText = numberWithCommas(totalPrice);
	},
	
	// 수량증가
	increaseQty(el) {
	  const input = el.closest('.updown').querySelector('.p_num');
	  input.value = parseInt(input.value) + 1;
	  this.changePNum();
	},
    // 감소
	decreaseQty(el) {
	  const input = el.closest('.updown').querySelector('.p_num');
	  const val = parseInt(input.value);
	  if (val > 1) {
	    input.value = val - 1;
	    this.changePNum();
	  }
	},
	// 상품삭제.
	delItem() {
		let del = document.querySelector('.row.data');
		del.remove();
		document.querySelector('.row.data').innerHTML;
	},
	// 선택상품삭제.
	delCheckedItem() {
		const checkedItem = document.querySelectorAll('.row.data input[name="buy"]:checked');
		
		checkedItem.forEach(checkbox => {
			checkbox.parentElement.parentElement.parentElement.remove();
		});
		//const delDiv = document.getElementById('cart-list');
		//const subdiv = parent.getElementsByClassName('subdiv');

		//for (let i = subdiv.length - 1; i >= 0; i--) {
		//  const subdiv = subdiv[i];
		//  const checkbox = subdiv.getElementsByClassName('checkbox')[0];

		//  if (checkbox && checkbox.checked) {
		//    delDiv.removeChild(subdiv);
		//  }
	//	}	
/*    let dCheckedItem = document.querySelectorAll('.row.data input[name="buy"]:checked');
	  dCheckedItem.forEach(checkbox => {
	    checkbox.parentNode.removeChild(checkbox);
	  });  */
	},
	// 장바구니 비우기.
	delAllItem() {
	  let element = document.getElementById('cart-list');
	  element.remove();
	}
} 
basket.updateList();

/*
	 let rows = document.querySelectorAll('.row.data');
	 let total = document.querySelector('#sum_p_num');
	 let totalPrice = document.querySelector('#sum_p_price');
	 console.log(rows);
	 console.log(total);
	 console.log(totalPrice);
	 // 수량 증가버튼기능
	 document.querySelector('.updown span i.fas.fa-arrow-alt-circle-up.up').addEventListener('click', function (e) {
	 	let value = document.querySelector('.updown input').value;
	 	if (value <= 4) {
	       value ++;
	 	  document.querySelector('#p_num1').innerHTML = "";  // 페이지 새로고침
	 	  alert('값증가');
	 	  console.log(value);
	 	} else {
	 		alert('최대수량은 4개 입니다');
	 		return;
	 	}
	 });

	 // 수량 감소버튼기능
	 document.querySelector('.updown span i.fas.fa-arrow-alt-circle-down.down').addEventListener('click', function (e) {
	    

	 });  
*/ 
/**
 * promise.js
 * 
 * Promise 객체역할
 * 비동기방식의 처리를 동기방식으로 순서 
 */

// 화살표함수
//function add(num1, num2) {
//	return num1 + num2;
//}
//const add = function add(num1, num2) {
//	return num1 + num2;
//}  // 줄여서 사용 가능

// 화살표 함수 예시
//const add = (num1, num2) => num1 + num2;



// 목록출력
fetch('replyList.do?bno=213')
.then(function(data) {
	//console.log(data);  // Response 결과값
	return data.json();  // json문자열 -> object로 변환
})
.then(function(result) {
	result.forEach(function(result) {
	        let tr = makeRow(result);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr)
			});
})
.catch(function(err) {
	console.log(err);
})  // end of 목록출력



// 댓글을 row 생성
function makeRow(result) {
	let tr = document.createElement('tr'); // <tr></tr> 요소를 만들어 줌!!
	tr.setAttribute('data-rno', result.replyNo);  // <tr data-rno="8"> <tr data-rno="9"> ... 
	// 글번호, 내용, 작성자 
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td'); // <td></td> 요소를 만들어 줌!!
		td.innerHTML = result[prop]; // == item['replyNo']
		tr.appendChild(td);  // tr이 부모요소 td가 자식요소 => 부모 자식요소로 만들어 줌!!  <tr><td></td></tr>
	}
	// 삭제button 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteReplyFnc);
	btn.innerHTML = '삭제';
	btn.className = 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;  // makeRow를 호출한 영역으로 tr 반환
} // end of makeRow



// 등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);

// 댓글등록 함수
function addReplyFnc(e) {
const bno = document.querySelector('#bno').value;
const reply = document.querySelector('#reply').value;

if (!bno || !reply || !logId) {
  alert('필수값 입력!');
  return;
	}
//ajax호출
//fetch(url) => get방식요철
//fetch(url, option) => post요청

// insert작업시 post요청
fetch('addReply.do', {
	method: 'post',
	headers: {'Content-Type': 'application/x-www-form-urlencoded'},
	body: 'bno='+ bno + '&reply='+ reply + '&replyer=' + logId
}).then(json => json.json())
  .then(result => {
	  if (result.retCode == 'Success') {
	  	alert('등록성공');
		let tr = makeRow(result.retVal);
		// 부모요소 insertBefore(새요소, 대상)
		let target = document.querySelector('table');
		document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
	} else {
		alert('등록실패');
	}
}).catch(err => console.log(err));
}// addReplyFnc

// 삭제함수
function deleteReplyFnc(e) {
	if(!confirm("삭제하시겠습니까?")) {
	  return;
	}
	//removeReply.do?rno=23 번과 같은 형태로 만들어야 함
	let rno = e.target.parentElement.parentElement.dataset.rno;
	//ajax 호출
	fetch('/removeReply.do?rno=' + rno)
	.then(json => json.json())  // 화살표함수 사용
	.then(data => {
		if(data.retCode == 'Success') {
			alert('삭제성공');
			e.target.parentElement.parentElement.remove();
		} else {
			alert('삭제실패');
		}
	})
	.catch(err => console.error(err))
}  // end of deleteReplyFnc


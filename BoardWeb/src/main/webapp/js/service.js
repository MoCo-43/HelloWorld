/**
 * service.js
 */

// svc객체의 add메소드
const svc = { //기능 정의
	add: function(num1=0, num2=0) {  // 메소드
		return num1 + num2;
	},
	// 목록출력 메소드
	replyList(param = {bno, page}, successCallback, errorCallback) { // function replyList() 와 같음  // 메소드(parameter 3개)
		// ajax호출
	  fetch('replyList.do?bno=' + param.bno + "&page=" + param.page)  // 댓글목록
	   .then(data => data.json()) // 위값이 성공했을떄
	   .then(successCallback)  // 위 값이 성공 시 함수를 전달
	   .catch(errorCallback)  // 예외발생시 전달
    },
	// 댓글삭제메소드
	removeReply(rno, successCallback, errorCallback) { // 댓글번호 , 성공, 실패
	  // ajax
	  fetch('removeReply.do?rno=' + rno)
	  .then(data => data.json()) 
	  .then(successCallback)
	  .catch(errorCallback)
	},
	// 댓글등록메소드
	addReply(param={ bno, reply, replyer }, successCallback, errorCallback) {  // parameter 3개 받음 오브젝트타입으로 + 성공 + 실패에 대한 파라미터 까지 받음
		/// 상단의 parma bno:bno, reply:reply, replyer:replyer = 선언된거랑 같음 => key:value key값 생략가능
		// ajax
		fetch('addReply.do', {
		  method: 'post',
		  headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		  body:  'bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer // param아래 주석 확인!! 
		})  // add같은경우는 보통 POST요청 처리함
		.then(data => data.json()) 
		.then(successCallback)  
		.catch(errorCallback)	
	},
	//댓글전체건수
	replyCount(bno, successCallback, errorCallback) {
		// ajax
		fetch("replyCount.do?bno="+ bno)
		.then(data => data.json()) 
		.then(successCallback)  
		.catch(errorCallback)	
	}
}
// add함수
const add = (num1, num2) => {
	return num1 + num2;
}

function makeRow(item) {
	console.log('makeRow');
	let tr = document.createElement('tr'); // <tr></tr> 요소를 만들어 줌!!
	tr.setAttribute('data-rno', item.replyNo);  // <tr data-rno="8"> <tr data-rno="9"> ... 
	// 글번호, 내용, 작성자 
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td'); // <td></td> 요소를 만들어 줌!!
		td.innerHTML = item[prop]; // == item['replyNo']
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







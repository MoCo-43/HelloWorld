/**
 * ajax2.js
 */
console.log(svc.add(10, 20));

svc.replyList(213, /*(parameter 1)게시글번호*/
	function(result) { 
		result.forEach(function(item) {
			        let tr = makeRow(item);
					document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
        });
	 }, /*(parameter 2)성공콜백함수*/
	 function(err) { 
		console.error(err);
	  }); /*(parameter 3)실패 콜백함수*/

// 등록이벤트
document.querySelector('#addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e) {
	//입력값 확인을 위해 필요
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;

	if (!bno || !reply || !logId) {
	  alert('필수값 입력!');
	  return;
		}
		
	// 메소드호출
    svc.addReply({bno, reply, replyer: logId },
		function(result) {
			  if (result.retCode == 'Success') {
			  	alert('등록성공');
				let tr = makeRow(result.retVal);
				// 부모요소 insertBefore(새요소, 대상)
				let target = document.querySelector('table:nth-of-type(2) tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록실패');
			}
		},
        err => console.error(err)
		
	);
}


// 삭제함수
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno, 
		function(result) {  // 성공했을때
			if(result.retCode == 'Success') {
						alert('삭제성공');
						e.target.parentElement.parentElement.remove();
					} else {
						alert('삭제실패');
					}
		},
		err => console.error(err) // 실패했을때
	);
} // end of deleteReplyFnc
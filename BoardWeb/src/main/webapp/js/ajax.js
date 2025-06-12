/*
 * ajax.js 
 * Asynchronous Javascript and Xml
 * 
 */
//비동기 vs 동기 방식
/* setTimeout(function(){
  console.log("1");	
}, 2000);

setTimeout(function(){
  console.log("2");	
}, 1000);

setTimeout(function(){
  console.log("start");	
}, 2500); */

// {"id", 1, "first_name", "Hong"} => json객체
// -> {id: 1, first_name: "Hong"}  => javascript객체

// 객체. XMLHttpRequest (비동기방식)
console.log("start");
let xhtp = new XMLHttpRequest();
xhtp.open('get', 'replyList.do?bno=221');  // 요청할 페이지 지정
xhtp.send();  // 페이지 요청
xhtp.onload = function() {
  console.log(xhtp.responseText);
  let data = JSON.parse(xhtp.responseText);
  data.forEach(function(item) {
	console.log(item);
	let tr = document.createElement('tr'); // <tr></tr> 요소를 만들어 줌!!
	// 글번호, 내용, 작성자 
	for (let prop of ['replyNo', 'reply', 'replyer']) {
	    let td = document.createElement('td'); // <td></td> 요소를 만들어 줌!!
	    td.innerHTML = item[prop]; // == item['replyNo']
	    tr.appendChild(td);  // tr이 부모요소 td가 자식요소 => 부모 자식요소로 만들어 줌!!  <tr><td></td></tr>
	}
	// 삭제button 생성
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.className= 'btn btn-danger';
	td.appendChild(btn);
	tr.appendChild(td); 
	document.querySelector('tbody').appendChild(tr);
  });
  // document.querySelector('#show').innerHTML = xhtp.responseText; 
};

function memberList() {
	//console.log("1");
	//console.log(xhtp.responseText);  // parsing
	let data = JSON.parse(xhtp.responseText);
	//console.log(data);
	let str = "<ul>";
	data.forEach(function(item, idx, arr) {
		console.log(item)
		str += "<li>"+item.id +", "+item.first_name+"</li>";
	});
	str += "</ul>"
	document.querySelector('#show').innerHTML = xhtp.responseText; 
}
console.log("end");




//fetch('data/sample.json')


/*
  .then(resolve => resolve.json())
  .then(data => 
	{console.log(data);
	data.forEach(function(item, idx, arr){
		
	});
  })

  .catch(err => {
	console.log(err);
  })
  
*/
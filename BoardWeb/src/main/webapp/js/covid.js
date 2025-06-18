/*
  covid.js
*/
import { makeRow, url } from './covid_module.js';

// document.querySelector('#centerList').innerHTML = "Hello";
let centerAry;
fetch(url)
   .then(data => data.json())
   .then(result => {
   centerAry = result.data;  // [ {}, {}, .... ,{}]
   console.log(centerAry);
   // tr>td*2
   // #centerList
   // [].forEach(Function(elem, idx, ary) { })
   let sidoAry = [];
   centerAry.forEach((center, idx) => {
	// sidoAry에 중복하지 않고 담기
	if(sidoAry.indexOf(center.sido) == -1) {  // 추가된 메소드가 있는지 없는지 확인
		sidoAry.push(center.sido);  // 추가, 
	}
    if (idx < 10) {
       // tr생성하기
       let tr = makeRow(center);
       document.querySelector('#centerList').appendChild(tr);
       }  // end of if
    })  // end of for
 	console.log(sidoAry);
	// sidoAry의 갯수만큼 <option value="sido정보">sido정보</option>
	sidoAry.forEach(sido => {  // 문자열을 담고 있는 정보를
	 let opt = document.createElement('option');
	 opt.value = sido;
	 opt.innerHTML = sido;
	 document.getElementById('sido').appendChild(opt);
	})
 })
 .catch(err => console.log(err))
   
   
// 등록버튼 event
document.querySelector('button.btn-primary').addEventListener('click', function(e) {
  document.querySelector('#centerList').innerHTML = ""; // 목록지우기
  let keyword = document.getElementById('centerName').value;  // 검색값

  centerAry // 전체건수를 가지고 있는 배열
  //.filter(center => center.centerName.indexOf(keyword) != -1)  // 배열
  .filter(center => center.centerName.includes(keyword))  // 배열
  .forEach(center => {
	let tr = makeRow(center);
	document.querySelector('#centerList').appendChild(tr);
  })
});

// select태그의 change이벤트 (기존방법)
/* document.querySelector('#sido').addEventListener('change', function(e) {
  document.querySelector('#centerList').innerHTML = ""; // 목록지우기
  let keyword = document.getElementById('sido').value;  // 검색값
  centerAry // 전체건수를 가지고 있는 배열
    .filter(center => center.sido == keyword)  // 배열
    .forEach(center => {
	  let tr = makeRow(center);
	  document.querySelector('#centerList').appendChild(tr);
  })
});
*/

// select태그의 change이벤트 (reduce() 사용)
document.querySelector('#sido').addEventListener('change', function(e) {
  document.querySelector('#centerList').innerHTML = ""; // 목록지우기
  let keyword = document.getElementById('sido').value;  // 검색값
  centerAry // 전체건수를 가지고 있는 배열
    .reduce((acc, center) => {
		if(center.sido == keyword) {
		  let tr = makeRow(center);
		  acc.appendChild(tr);
		}
		return acc;
	}, document.querySelector('#centerList'));
});






// [].push(), [].unshift(), [].pop(), [].unshift() => [].splice()  
// reduce();  => parameter ( 누산기 (acc), 배열요소 (elem), 현재 인덱스 (idx), 원본 배열 (src) )
let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary) {
	//console.log(acc, elem);  // acc와 elem으로 간단한 연산 가능한 예시
	//return acc + elem;  // 첫번째 1 +3, 두번째 4+5 , 세번째 9+7
	//console.log(acc, elem);
	if(elem > 4) {
	  let li = document.createElement('li');
	  li.innerHTML = elem;
	  acc.appendChild(li);
	}
	return acc;  // 다음순번인 acc값으로 반환 => 하지 않는다면 다음값은 undefine으로 출력 됨
}, document.querySelector('#target'));
// console.log("결과: ", result);
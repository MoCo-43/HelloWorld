/**
 * covid_module.js 
 */
const deFaultNum = 10;

let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=gLkZTIcOy898Hj16MHFeimJi5FcPy9uDVR1mt4yVjbzaIYU4GE3V2D6XVkKzlpdlhVTIcc%2Fgc99OoNGpf2w5DQ%3D%3D`

function makeRow(center) {
  let tr = document.createElement('tr');
  for(const prop of ['id', 'centerName', 'phoneNumber', 'address']) {  
	let td = document.createElement('td'); // <td></td>
	td.innerHTML = center[prop];  // center['id']  // <td>1</td>
	tr.appendChild(td);
	}
  return tr;
}

export { makeRow, url }  // 내보내고 싶은 함수만 사용할때 export
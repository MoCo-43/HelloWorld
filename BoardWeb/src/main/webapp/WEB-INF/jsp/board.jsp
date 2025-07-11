<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="//cdn.datatables.net/2.3.2/css/dataTables.dataTables.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.3.2/js/dataTables.min.js"></script>

<h3>상세화면(board.jsp)</h3>
<form action="modifyBoard.do">
  <input type="hidden" name="bno" value="${board.boardNo }">
  <input type="hidden" name="page" value="${page }">
  <input type="hidden" name="searchCondition" value="${searchCondition }">
  <input type="hidden" name="keyword" value="${keyword }">
  <table class="table">
  <!-- datatable 활용 -->
    <tr>
      <th>글번호</th>
      <td>${board.boardNo }</td>
      <th>조회수</th>
      <td>${board.readCnt }</td>
    </tr>
    <tr>
      <th>제목</th>
      <td colspan="3">${board.title }</td>
    </tr>
    <tr>
      <th>내용</th>
      <td colspan="3">
        <textarea cols="45" rows="3" class="form-control" readonly>${board.content }</textarea></td>
    </tr>
    <tr>
      <th>작성자</th>
      <td colspan="3">${board.writer }</td>
    </tr>
    <tr>
      <th>작성일시</th>
      <td colspan="3">${board.writeDate }</td>
    </tr>
    <tr>
      <td colspan="4" align="center">
        <input type="submit" value="수정" class="btn btn-warning">
        <button class="btn btn-danger" type="button">삭제</button>
      </td>
    </tr>
  </table>
</form>
<!-- 댓글관련 페이지 -->
<style>
  div.reply ul {
    list-style-type: none;
  }

  div.reply span {
    display: inline-block;
  }
</style>
<div class="container reply">
  <div class="header">
    <input class="col-sm-8" id="reply">
    <button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
    <button class="col-sm-3 btn btn-danger" id="delReply">삭제</button>
  </div>
  <table id="example" class="display">
        <thead>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>댓글번호</th>
                <th>내용</th>
                <th>작성자</th>
                <th>작성일시</th>
            </tr>
        </tfoot>
    </table>
  <!-- 댓글관련 페이지 -->
  
</div>
<!-- 댓글관련 페이지 -->

<script>
  let bno = "${board.boardNo}";
  let logId = "${logId}";
  document.querySelector('button.btn-danger').addEventListener('click', function () {
    location.href = 'removeBoard.do?bno=' + bno;
  })
</script>
<script>
new DataTable('#example', {
    ajax: 'replyList.do?bno='+bno,
    columns: [
        { data: 'replyNo' },
        { data: 'reply' },
        { data: 'replyer' },
        { data: 'replyDate' },
    ],
    lengthMenu: [5, 10, 15, -1],
    order: [[0, 'desc']]
});

const table = new DataTable('#example');
function addNewRow() {
    // ajax 호출
    let reply = document.querySelector('#reply').value;
    console.log(reply);
    if(!reply || !logId) {
	  return;
    }
    fetch('addReply.do?bno='+bno+'&reply='+reply+'&replyer='+logId)
    .then(data => data.json())
    .then(result => {
	console.log(result);
	let rvo = result.retVal;
    // 화면추가
    table.row
        .add({replyNo: rvo.replyNo,
              reply: rvo.reply,
              replyer: rvo.replyer,
              replyDate: rvo.replyDate
          })
        .draw(false);
    })
    .catch(err => console.log(err));
}
document.querySelector('#addReply').addEventListener('click', addNewRow);


// 한줄 삭제 버튼(비동기처리)
document.querySelector('#delReply').addEventListener('click', async function () {  
// 화면갱신
    if(!document.querySelector('tr.selected')) {
      alert('댓글을 선택하세요.');
      return;
    }
    // 삭제할 댓글번호
    let rno = document.querySelector('tr.selected').children[0].innerHTML;
    let data = await fetch('removeReply.do?rno='+rno);
    let result = await data.json();
    if(result.retCode == 'Success') {
        table.row('.selected').remove().draw(false);  // remove()후 draw(false) 화면을 갱신
    }
});

//row삭제
table.on('click', 'tbody tr', (e) => {
    let classList = e.currentTarget.classList;  // <tr>안의 클래스를 다 들고옴
 
    if (classList.contains('selected')) {  // 선택 항목 표시 
        classList.remove('selected');
    }
    else {  // 선택후 이전의 선택값을 지우는작업
        table.rows('.selected').nodes().each((row) => row.classList.remove('selected'));
        classList.add('selected');
    }
});
</script>
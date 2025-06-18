<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signup.jsp)</h3>
<form name="signForm" action="signup.do" method="post" enctype="multipart/form-data">  <!-- type=""에서 다양한 타입으로 처리 할 수 있음 -->
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId" required></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw" required></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName"></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
  let check = false;
  // document.forms
  console.log(document.forms.signForm);  // signForm값 확인해보기
  document.forms.signForm.addEventListener('submit', function(e) {
    if(!check) {
      e.preventDefault();  // formSubmit을 하더라도 이동하지 않게 하는것
      alert('입력값을 확인하세요');
      return;
    }
    
    this.submit();
  })
  document.querySelector('input[name="userId"]').addEventListener('change', function (e){
    console.log(this);  // input태그를 가르킴
    let user = this.value;
    let passInput = document.querySelector('input[name="userPw"]');
    let pass = passInput.value;
    console.log(pass);
    if (pass.length < 5) {
      alert('최소 5자리 이상의 비밀번호를 입력하세요');
      check = false;
    }

    // 회원가입 check
    fetch('checkId.do?id='+ user+'&pw='+pass)
        .then(data => data.json())
        .then(result => {
          if(result.retCode == "Exist" ) {
            alert('존재하는 아이디');
            console.log(pass);
        } else {
        	alert('사용가능한 아이디');
        	check = true;
          }
        })
        .catch(err => console.log(err))
})
</script>
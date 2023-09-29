<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>

  $(function(){

    fnName();
    fnRegister();
  })

  function fnRegister(){
    $('#frm_add').click(function(event){
      if(!confirm('학생이 등록 되었습니다.')){
        return;
      }
      location.href = '${contextPath}/student/add.do';

    })
  }

  function fnName() {
    if($('#name').val() === ''){
      alert('이름은 필수입니다.');
      $('#name').focus();
      event.preventDefault();
      return;
      }
    });
  }

</script>
</head>
<body>
  <h1>신규학생등록화면</h1>

  <div>
    <form id="frm_add" method="post" action="${contextPath}/student/add.do">
      <div>
        <label for="name">이름</label>
        <input type="text" id="name" name="name">
      </div>
      <div>
        <label for="kor">국어</label>
        <input type="text" id="kor" name="kor">
      </div>
       <div>
        <label for="eng">영어</label>
        <input type="text" id="eng" name="eng">
      </div>
       <div>
        <label for="math">수학</label>
        <input type="text" id="math" name="math">
      </div>
  
  <hr>
  
      <div>
        <button type="submit" id=btn_register >작성완료</button>
        <button type="reset">다시작성</button>
        <button type="button" id="btn_stuList">목록보기</button>
      </div>  
    </form>
   </div>

</body>
</html>
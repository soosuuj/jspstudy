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
    fnList();
    fnAdd();
  })

  function fnList(){
    $('#btn_stuList').click(function(){  
      location.href = '${contextPath}/student/list.do';
    })
  }
  function fnAdd(){
    $('#frm_add').submit(function(event){
      if($('#name').val() === ''){
        alert('이름은 필수입니다.');
        $('#name').focus();
        event.preventDefault();
        return;
      }
    })
  }

</script>
</head>
<body>
  <h1>학생 상세 조회</h1>

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
      <div>
        <label for="ave">평균</label>
        <input type="text" id="ave" name="ave" readonly >
      </div>
      <div>
        <label for="grade">학점</label>
        <input type="text" id="grade" name="grade" readonly>
      </div>
 
  
  <hr>
  
      <div>
        <button type="submit" >수정하기</button>
        <button type="button" id="btn_stuList">목록보기</button>
      </div>  
    </form>
   </div>

</body>
</html>
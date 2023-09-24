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
    fnAdd();
    fndetail();
    fndetail();
    fnDelete();
  })
  
  function fnAdd(){
    $('#btn_add').click(function(){
      location.href = '${contextPath}/student/write.do=' + $(this).parent().data('stu_no');
    })
  }
    
  function fndetail(){
    $('.btn_detail').click(function(){
      location.href = '${contextPath}/student/detail.do?stuNo=' + $(this).parent().data('stu_no');
    })
  }
  
  function fnDelete(){
    $('.btn_delete').click(function(){
      location.href = '${contextPath}/student/delete.do?stuNo=' + $(this).parent().data('stu_no');
    })
  }
    


</script>
</head>
<body>
  <h1>학생 관리</h1>

  <div>
    <button type="button" id="btn_add">신규학생등록</button>
  </div>
  
  <hr>
  
  <div> 
    <label>평균</label>
    <input type="text" placeholder="begin"> ~ <input type="text" placeholder="end">
    <button id="btn_view">조회</button>
    <button id="btn_Allview">전체조회</button>
  </div>
  
  <hr>
    <div class="student_list">
      <table border="1">
      <caption>전체 학생<span id="studentCount"></span>명</caption>
      
      <thead>
        <tr>
          <td>학번</td>
          <td>성명</td>
          <td>국어</td>
          <td>영어</td>
          <td>수학</td>
          <td>평균</td>
          <td>학점</td>
          <td>버튼</td>
        </tr>
      </thead>
        
      <tbody>
          <c:forEach items="${studentList}" var="student">
              <tr>
                  <td>${student.stuNo}</td>
                  <td>${student.name}</td>
                  <td>${student.kor}</td>
                  <td>${student.eng}</td>
                  <td>${student.math}</td>
                  <td>${student.ave}</td>
                  <td>${student.grade}</td>                 
                  <td data-stu_no="${student.stuNo}">             
                    <button type="button" class="btn_detail">상세</button>
                    <button type="button" class="btn_delete">삭제</button>
                  </td>
              </tr>
          </c:forEach>
      </tbody>
        <tr>
          <td colspan="5">전체평균</td>
          <td></td>
          <td colspan="2"></td>
        </tr>
    </table>
  </div>
  

</body>
</html>
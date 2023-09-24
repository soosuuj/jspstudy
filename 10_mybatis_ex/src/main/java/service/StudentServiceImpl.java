package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.StudentDto;
import repository.StudentDao;

public class StudentServiceImpl implements StudentService {

  private StudentDao dao = StudentDao.getDao();

  @Override
  public ActionForward studentList(HttpServletRequest request) {

    Map<String, Object> map = new HashMap<String, Object>();

    List<StudentDto> studentList = dao.studentList(map);
    request.setAttribute("studentList", studentList);
    return new ActionForward("/student/list.jsp", false);
  }
  
  @Override
  public ActionForward studentDetail(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
    int stuNo = Integer.parseInt(opt.orElse("0"));
    StudentDto student = dao.studentDetail(stuNo);
    request.setAttribute("student", student);
    return new ActionForward("/student/detail.jsp", false);
  }
  
  @Override
  public ActionForward studentAdd(HttpServletRequest request) {

    String name = request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));
    int ave = (kor + eng + math) /3 ;


    StudentDto dto = StudentDto.builder()
                    
                    .name(name)
                    .kor(kor)
                    .eng(eng)
                    .math(math)
                    .ave(ave)
                   // .grade(grade)
                    .build();
    int addResult = dao.studentAdd(dto);
    String path = null;
    switch(addResult) {
    case 0: path = request.getContextPath() + "/index.do"; break;
    case 1: path = request.getContextPath() + "/student/list.do"; break;    
    }
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward studentEdit(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
    int stuNo = Integer.parseInt(opt.orElse("0"));
    StudentDto student = dao.studentDetail(stuNo);
    request.setAttribute("student", student);
    return new ActionForward("/student/edit.jsp", false);
  }
  
  @Override
  public ActionForward studentModify(HttpServletRequest request) {
    int stuNo = Integer.parseInt(request.getParameter("stuNo"));
    String name = request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));
    int ave = (kor + eng + math) /3 ;
  //  String grade = request.getParameter("grade");
    StudentDto dto = StudentDto.builder()
                    .stuNo(stuNo)
                    .name(name)
                    .kor(kor)
                    .eng(eng)
                    .math(math)
                    .ave(ave)
               //     .grade(grade)
                    .build();
    int modifyResult = dao.studentModify(dto);
    String path = null;
    switch(modifyResult) {
    case 0: path = request.getContextPath() + "/index.do"; break;
    case 1: path = request.getContextPath() + "/student/detail.do?stuNo=" + stuNo; break;    
    }
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward studentDelete(HttpServletRequest request) {
    Optional<String> opt = Optional.ofNullable(request.getParameter("stuNo"));
    int stuNo = Integer.parseInt(opt.orElse("0"));
    int deleteResult = dao.studentDelete(stuNo);
    String path = null;
    switch(deleteResult) {
    case 0: path = request.getContextPath() + "/index.do"; break;
    case 1: path = request.getContextPath() + "/student/list.do"; break;    
    }
    return new ActionForward(path, true);
  }
  
}

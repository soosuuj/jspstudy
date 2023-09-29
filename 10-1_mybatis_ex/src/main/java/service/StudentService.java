package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface StudentService {

  public ActionForward studentList(HttpServletRequest request);
  public ActionForward studentDetail(HttpServletRequest request);
  public ActionForward studentAdd(HttpServletRequest request);
  public ActionForward studentEdit(HttpServletRequest request);
  public ActionForward studentModify(HttpServletRequest request);
  public ActionForward studentDelete(HttpServletRequest request);
}
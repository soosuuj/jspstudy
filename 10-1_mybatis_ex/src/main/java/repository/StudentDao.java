package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.StudentDto;

public class StudentDao {

    // mybatis의 SqlSession을 만들 수 있는 SqlSessionFactory 선언
    private SqlSessionFactory factory;
    
    // Singleton Pattern
    private static StudentDao dao = new StudentDao();
    private StudentDao() {
      // SqlSessionFactory 생성
      try {
        String resource = "mybatis/config/mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(in);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    public static StudentDao getDao() {
      return dao;
    }
  
    // 매퍼의 namespace
    private final String NS = "mybatis.mapper.student.";
    
    // 전체 개수 반환 메소드

    public int studentCount() {
      SqlSession ss = factory.openSession();
      int count = ss.selectOne(NS + "studentCount");
      ss.close();
      return count;
    }
    // 목록 반환 메소드

    public List<StudentDto> studentList(Map<String, Object> map) {
      SqlSession ss = factory.openSession();
      List<StudentDto> list = ss.selectList(NS + "studentList", map);
      ss.close();
      return list;
    }
    // 상세 반환 메소드

    public StudentDto studentDetail(int stuNo) {
      SqlSession ss = factory.openSession();
      StudentDto dto = ss.selectOne(NS + "studentDetail", stuNo);
      ss.close();
      return dto;
    }
    
    // 등록
    public int studentAdd(StudentDto dto) {
      SqlSession ss = factory.openSession(false);  // false : 내가 커밋하겠다.
      int addResult = ss.insert(NS + "studentAdd", dto);
      if(addResult == 1) {
        ss.commit();
      }
      ss.close();
      return addResult;
    }
  
  
  // 수정 메소드
    public int studentModify(StudentDto dto) {
      SqlSession ss = factory.openSession(false);
      int modifyResult = ss.update(NS + "studentModify", dto);
      if(modifyResult == 1) {
        ss.commit();
      }
      ss.close();
      return modifyResult;
    }
  
  
  // 삭제 메소드
    public int studentDelete(int stuNo) {
      SqlSession ss = factory.openSession(false);
      int deleteResult = ss.delete(NS + "studentDelete", stuNo);
      if(deleteResult == 1) {
        ss.commit();
      }
      ss.close();
      return deleteResult;
    }
    
  
}

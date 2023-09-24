package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDto {
  private int stuNo;
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int ave;
  private String grade;
   

}

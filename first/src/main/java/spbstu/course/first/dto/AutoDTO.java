package spbstu.course.first.dto;

import lombok.Data;

@Data
public class AutoDTO {
  private Long id;
  private String num;
  private String color;
  private String mark;
  private PersonnelDTO personnel;
}

package spbstu.course.first.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Auto {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20)
  private String num;

  @Column(length = 20)
  private String color;

  @Column(length = 20)
  private String mark;

  @ManyToOne
  private Personnel personnel;
}

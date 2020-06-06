package spbstu.course.first.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Route {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50)
  private String name;
}

package spbstu.course.first.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Personnel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 20)
  private String firstname;

  @Column(length = 20)
  private String lastname;

  @Column(length = 20)
  private String pathername;
}

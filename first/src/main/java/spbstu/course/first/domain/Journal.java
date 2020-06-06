package spbstu.course.first.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Journal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private LocalDateTime timeout;

  private LocalDateTime timein;

  @ManyToOne
  private Auto auto;

  @ManyToOne
  private Route route;
}

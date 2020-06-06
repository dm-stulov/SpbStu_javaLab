package spbstu.course.first.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JournalDTO {
  private Long id;
  private LocalDateTime timeout;
  private LocalDateTime timein;
  private AutoDTO auto;
  private RouteDTO route;
}

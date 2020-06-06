package spbstu.course.first.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.first.domain.Auto;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long> {
}

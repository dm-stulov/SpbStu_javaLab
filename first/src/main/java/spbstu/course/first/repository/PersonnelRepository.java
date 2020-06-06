package spbstu.course.first.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.first.domain.Personnel;

@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long> {

}

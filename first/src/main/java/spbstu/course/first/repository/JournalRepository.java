package spbstu.course.first.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.first.domain.Journal;

@Repository
public interface JournalRepository extends CrudRepository<Journal, Long> {

}

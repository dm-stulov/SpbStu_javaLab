package spbstu.course.first.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spbstu.course.first.domain.Route;

@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {
}

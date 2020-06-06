package spbstu.course.first.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spbstu.course.first.domain.Route;
import spbstu.course.first.dto.RouteDTO;
import spbstu.course.first.repository.RouteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {
  private final ModelMapper modelMapper;
  private final RouteRepository repository;

  public RouteService(ModelMapper modelMapper, RouteRepository repository) {
    this.modelMapper = modelMapper;
    this.repository = repository;
  }

  public List<RouteDTO> getAll() {
    List<RouteDTO> routes = new ArrayList<>();

    repository.findAll().forEach(route ->
        routes.add(modelMapper.map(route, RouteDTO.class))
    );

    return routes;
  }

  public RouteDTO get(Long id) {
    return modelMapper.map(repository.findById(id).get(), RouteDTO.class);
  }

  public RouteDTO save(RouteDTO routeDTO) {

    return  modelMapper
        .map(repository.save(modelMapper
            .map(routeDTO, Route.class)), RouteDTO.class);
  }

  public void delete(RouteDTO routeDTO) {
    repository.delete(
        modelMapper.map(routeDTO, Route.class));
  }
}

package spbstu.course.first.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spbstu.course.first.domain.Auto;
import spbstu.course.first.dto.AutoDTO;
import spbstu.course.first.repository.AutoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService {
  private final ModelMapper modelMapper;
  private final AutoRepository repository;

  public AutoService(ModelMapper modelMapper, AutoRepository repository) {
    this.modelMapper = modelMapper;
    this.repository = repository;
  }

  public List<AutoDTO> getAll() {
    List<AutoDTO> autos = new ArrayList<>();

    repository.findAll().forEach(auto ->
        autos.add(modelMapper.map(auto, AutoDTO.class))
    );

    return autos;
  }

  public AutoDTO get(Long id) {
    return modelMapper
        .map(repository.findById(id), AutoDTO.class);
  }

  public AutoDTO save(AutoDTO autoDTO) {
    return modelMapper
        .map(repository.save(modelMapper
            .map(autoDTO, Auto.class)), AutoDTO.class);
  }

  public AutoDTO put(AutoDTO autoDTO) {
    return modelMapper
        .map(repository.save(modelMapper
            .map(autoDTO, Auto.class)), AutoDTO.class);
  }

  public void delete(Auto auto) {
    repository.delete(auto);
  }
}

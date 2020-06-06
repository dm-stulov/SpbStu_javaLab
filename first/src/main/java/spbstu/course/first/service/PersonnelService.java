package spbstu.course.first.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spbstu.course.first.domain.Personnel;
import spbstu.course.first.dto.PersonnelDTO;
import spbstu.course.first.repository.PersonnelRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonnelService {
  private final ModelMapper modelMapper;
  private final PersonnelRepository repository;

  public PersonnelService(ModelMapper modelMapper, PersonnelRepository repository) {
    this.modelMapper = modelMapper;
    this.repository = repository;
  }

  public List<PersonnelDTO> getAll() {
    List<PersonnelDTO> personnels = new ArrayList<>();

    repository.findAll().forEach(personnel ->
        personnels.add(modelMapper.map(personnel, PersonnelDTO.class))
    );

    return personnels;
  }

  public PersonnelDTO get(Long id) {
    return modelMapper
        .map(repository.findById(id).get(), PersonnelDTO.class);
  }

  public PersonnelDTO save(PersonnelDTO personnelDTO) {
    return modelMapper
        .map(repository.save(modelMapper
            .map(personnelDTO, Personnel.class)), PersonnelDTO.class);
  }

  public PersonnelDTO put(PersonnelDTO personnelDTO) {
    return modelMapper
        .map(repository.save(modelMapper
            .map(personnelDTO, Personnel.class)), PersonnelDTO.class);
  }

  public void delete(PersonnelDTO personnelDTO) {
    repository.delete(modelMapper.map(personnelDTO, Personnel.class));
  }
}

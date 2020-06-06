package spbstu.course.first.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spbstu.course.first.domain.Journal;
import spbstu.course.first.dto.JournalDTO;
import spbstu.course.first.repository.JournalRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JournalService {
  private final ModelMapper modelMapper;
  private final JournalRepository repository;

  public JournalService(ModelMapper modelMapper, JournalRepository repository) {
    this.modelMapper = modelMapper;
    this.repository = repository;
  }


  public List<JournalDTO> getAll() {
    List<JournalDTO> journals = new ArrayList<>();

    repository.findAll().forEach(journal ->
        journals.add(modelMapper.map(journal, JournalDTO.class))
    );

    return journals;
  }

  public JournalDTO get(Long id) {
    return modelMapper
        .map(repository.findById(id).get(), JournalDTO.class);
  }

  public JournalDTO save(JournalDTO journalDTO) {
    return modelMapper
        .map(repository.save(modelMapper
            .map(journalDTO, Journal.class)), JournalDTO.class);
  }

  public void delete(JournalDTO journalDTO) {
    repository.delete(
        modelMapper.map(journalDTO, Journal.class)
    );
  }
}

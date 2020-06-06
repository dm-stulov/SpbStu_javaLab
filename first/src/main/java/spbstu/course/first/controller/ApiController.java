package spbstu.course.first.controller;

import org.springframework.web.bind.annotation.*;
import spbstu.course.first.domain.Auto;
import spbstu.course.first.dto.AutoDTO;
import spbstu.course.first.dto.JournalDTO;
import spbstu.course.first.dto.PersonnelDTO;
import spbstu.course.first.dto.RouteDTO;
import spbstu.course.first.service.AutoService;
import spbstu.course.first.service.JournalService;
import spbstu.course.first.service.PersonnelService;
import spbstu.course.first.service.RouteService;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {
  private final AutoService autoService;
  private final JournalService journalService;
  private final PersonnelService personnelService;
  private final RouteService routeService;

  public ApiController(
      AutoService autoService,
      JournalService journalService,
      PersonnelService personnelService,
      RouteService routeService
  ) {
    this.autoService = autoService;
    this.journalService = journalService;
    this.personnelService = personnelService;
    this.routeService = routeService;
  }

  @GetMapping("auto")
  public List<AutoDTO> getAutoAll() {
    return autoService.getAll();
  }

  @PutMapping("auto")
  public AutoDTO putAuto(@RequestBody AutoDTO autoDTO) {
    return autoService.put(autoDTO);
  }

  @GetMapping("auto/{id}")
  public AutoDTO getAutoById(@PathVariable Long id) {
    return autoService.get(id);
  }

  @PostMapping("auto")
  public AutoDTO saveAuto(@RequestBody AutoDTO autoDTO) {
    return autoService.save(autoDTO);
  }

  @DeleteMapping("auto/{id}")
  public void deleteAuto(@PathVariable("id") Auto auto) {
    autoService.delete(auto);
  }

  @GetMapping("journal")
  public List<JournalDTO> getJournalAll() {
    return journalService.getAll();
  }

  @GetMapping("journal/{id}")
  public JournalDTO getJournalById(@PathVariable Long id) {
    return journalService.get(id);
  }

  @PostMapping("journal")
  public JournalDTO saveAuto(@RequestBody JournalDTO journalDTO) {
    return journalService.save(journalDTO);
  }

  @PutMapping("journal")
  public JournalDTO udpateAuto(@RequestBody JournalDTO journalDTO) {
    return journalService.save(journalDTO);
  }

  @DeleteMapping("journal")
  public void deleteAuto(@RequestBody JournalDTO journalDTO) {
    journalService.delete(journalDTO);
  }

  @GetMapping("personnel")
  public List<PersonnelDTO> getPersonnelAll() {
    return personnelService.getAll();
  }

  @PutMapping("personnel")
  public PersonnelDTO putPersonnel(@RequestBody PersonnelDTO personnelDTO) {
    return personnelService.put(personnelDTO);
  }

  @DeleteMapping("personnel")
  public void deleteAuto(@RequestBody PersonnelDTO personnelDTO) {
    personnelService.delete(personnelDTO);
  }

  @GetMapping("personnel/{id}")
  public PersonnelDTO getPersonnelById(@PathVariable Long id) {
    return personnelService.get(id);
  }

  @PostMapping("personnel")
  public PersonnelDTO savePersonnel(@RequestBody PersonnelDTO personnelDTO) {
    return personnelService.save(personnelDTO);
  }

  @GetMapping("route")
  public List<RouteDTO> getRouteAll() {
    return routeService.getAll();
  }

  @GetMapping("route/{id}")
  public RouteDTO getRouteById(@PathVariable Long id) {
    return routeService.get(id);
  }

  @PostMapping("route")
  public RouteDTO saveRoute(@RequestBody RouteDTO routeDTO) {
    return routeService.save(routeDTO);
  }

  @PutMapping("route")
  public RouteDTO updateRoute(@RequestBody RouteDTO routeDTO) {
    return routeService.save(routeDTO);
  }

  @DeleteMapping("route")
  public void deleteRoute(@RequestBody RouteDTO routeDTO) {
    routeService.delete(routeDTO);
  }
}

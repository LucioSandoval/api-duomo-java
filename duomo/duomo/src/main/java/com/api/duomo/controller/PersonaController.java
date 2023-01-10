package com.api.duomo.controller;

import com.api.duomo.dto.PersonaDTO;
import com.api.duomo.exception.ResourceNotFoundException;
import com.api.duomo.model.Comuna;
import com.api.duomo.model.Region;
import com.api.duomo.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
  @Autowired
  private IPersonaService personaService;
  // Probando comentarios

  @PostMapping(value = "/persona/{idregion}/{idcomuna}",consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO personaDTO,@PathVariable(value = "idregion") long idregion,@PathVariable(value = "idcomuna") long idcomuna )
      throws ResourceNotFoundException {
    return new ResponseEntity<>(personaService.create(personaDTO,idregion,idcomuna), HttpStatus.CREATED);

  }

  @GetMapping(value = "/persona", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PersonaDTO> findAll(){

    return personaService.list();
  }

  @GetMapping(value = "/region", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Region> getRegion(){

    return personaService.getRegion();
  }


  @GetMapping(value = "/comuna", params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Comuna> getComuna(@RequestParam(value = "id") long id){

    return personaService.getComuna(id);
  }


  @PutMapping(value = "/persona/{personaId}/{regionId}/{comunaId}", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonaDTO> update(@RequestBody PersonaDTO personaDTO, @PathVariable(value = "personaId") long personaId,
      @PathVariable(value = "regionId") long regionId, @PathVariable(value = "comunaId") long comunaId)
      throws ResourceNotFoundException {
    return new ResponseEntity<>(personaService.update(personaDTO,personaId, regionId, comunaId ), HttpStatus.CREATED);

  }


  @DeleteMapping(value = "/persona/{id}")
  public ResponseEntity<String> delete(@PathVariable(value = "id") long id)
      throws ResourceNotFoundException {
    personaService.delete(id);
    return new ResponseEntity<>( "Persona elimanada exitosamente", HttpStatus.OK);

  }

  @GetMapping(value = "/persona/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PersonaDTO> findById(@PathVariable(value = "id") long id)
      throws ResourceNotFoundException {
    return new ResponseEntity<>( personaService.findById(id), HttpStatus.OK);

  }

}

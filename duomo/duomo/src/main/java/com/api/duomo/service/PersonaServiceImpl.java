package com.api.duomo.service;

import com.api.duomo.dto.PersonaDTO;
import com.api.duomo.exception.ResourceNotFoundException;
import com.api.duomo.model.Comuna;
import com.api.duomo.model.Persona;
import com.api.duomo.model.Region;
import com.api.duomo.repository.IComunaRepository;
import com.api.duomo.repository.IPersonaRepository;
import com.api.duomo.repository.IRegionRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements IPersonaService {

  @Autowired
  private IPersonaRepository personaRepository;

  @Autowired
  private IComunaRepository comunaRepository;

  @Autowired
  private IRegionRepository regionRepository;

  @Override
  public PersonaDTO create(PersonaDTO personaDTO, long regionId, long comunaId)
      throws ResourceNotFoundException {

    Region region = regionRepository.findById(regionId).orElseThrow( () -> new ResourceNotFoundException("Region", "id", regionId));
    Comuna comuna = comunaRepository.findById(comunaId).orElseThrow( () -> new ResourceNotFoundException("Comuna", "id", regionId));

    personaDTO.setRegion(region);
    personaDTO.setComuna(comuna);
    Persona persona = mapearPersona1(personaDTO);
    Persona newPersona = personaRepository.save(persona);

    return mapearDTO1(newPersona);
  }

  @Override
  public List<PersonaDTO> list() {
    List<Persona> personaList = personaRepository.getAll();



    return personaList.stream().map((persona)-> mapearDTO1(persona)).collect(Collectors.toList());
  }

  @Override
  public PersonaDTO update(PersonaDTO personaDTO, long personaId, long regionId, long comunaId)
      throws ResourceNotFoundException {

    Region region = regionRepository.findById(regionId).orElseThrow( () -> new ResourceNotFoundException("Region", "id", regionId));
    Comuna comuna = comunaRepository.findById(comunaId).orElseThrow( () -> new ResourceNotFoundException("Comuna", "id", regionId));
    Persona persona = personaRepository.findById(personaId).orElseThrow( () -> new ResourceNotFoundException("Persona", "id", regionId));



    persona.setNombre(personaDTO.getNombre());
    persona.setApellido(personaDTO.getApellido());
    persona.setCorreo(personaDTO.getCorreo());
    persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
    persona.setTelefono(personaDTO.getTelefono());
    persona.setRegionId(region);
    persona.setComunaId(comuna);
    Persona newPersona = personaRepository.save(persona);


    return mapearDTO1(newPersona);
  }

  @Override
  public void delete(long id) throws ResourceNotFoundException {
    Persona persona = personaRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Persona", "id",id));
    personaRepository.delete(persona);
  }

  @Override
  public PersonaDTO findById(long id) throws ResourceNotFoundException {
    Persona persona = personaRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Persona", "id", id));

    return mapearDTO1(persona);
  }


  @Override
  public List<Region> getRegion() {
    List<Region> regionList = regionRepository.findAll();
    return regionList;
  }

  @Override
  public List<Comuna> getComuna(long id) {
    List<Comuna> comunaList = comunaRepository.findByComuna(id);
    return comunaList;
  }


  private PersonaDTO mapearDTO1(Persona persona){
    PersonaDTO personaDTO = new PersonaDTO();
    personaDTO.setId(persona.getId());
    personaDTO.setNombre(persona.getNombre());
    personaDTO.setApellido(persona.getApellido());
    personaDTO.setCorreo(persona.getCorreo());
    personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
    personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
    personaDTO.setTelefono(persona.getTelefono());
    personaDTO.setRegion(persona.getRegionId());
    personaDTO.setComuna(persona.getComunaId());

    return personaDTO;
  }

  private Persona mapearPersona1(PersonaDTO personaDTO){
    Persona persona = new Persona();
    persona.setId(personaDTO.getId());
    persona.setNombre(personaDTO.getNombre());
    persona.setApellido(personaDTO.getApellido());
    persona.setCorreo(personaDTO.getCorreo());
    persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
    persona.setTelefono(personaDTO.getTelefono());
    persona.setRegionId(personaDTO.getRegion());
    persona.setComunaId(personaDTO.getComuna());


    return persona;
  }

}

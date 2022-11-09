package com.api.duomo.service;

import com.api.duomo.dto.PersonaDTO;
import com.api.duomo.exception.ResourceNotFoundException;
import com.api.duomo.model.Comuna;
import com.api.duomo.model.Region;
import java.util.List;

public interface IPersonaService {
  public PersonaDTO create(PersonaDTO personaDTO, long region, long comuna)
      throws ResourceNotFoundException;
  public List<PersonaDTO> list();
  public PersonaDTO update(PersonaDTO personaDTO, long personaId, long regionId,long comunaId)
      throws ResourceNotFoundException;
  public void delete(long id) throws ResourceNotFoundException;

  public PersonaDTO findById(long id) throws ResourceNotFoundException;



  public List<Region> getRegion();
  public List<Comuna> getComuna(long id);




}

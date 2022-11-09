package com.api.duomo.repository;

import com.api.duomo.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPersonaRepository extends JpaRepository<Persona, Long> {

  @Query(value = "SELECT * FROM personas", nativeQuery = true)
  public List<Persona> getAll();


}

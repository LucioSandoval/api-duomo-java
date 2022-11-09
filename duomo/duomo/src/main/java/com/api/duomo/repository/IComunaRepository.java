package com.api.duomo.repository;

import com.api.duomo.model.Comuna;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IComunaRepository extends JpaRepository<Comuna, Long> {

  @Query(value = "select * from comunas where region_id = :id",nativeQuery = true)
  public List<Comuna>findByComuna(@Param(value = "id") long id);

}

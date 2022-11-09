package com.api.duomo.repository;

import com.api.duomo.model.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegionRepository extends JpaRepository<Region, Long> {

}

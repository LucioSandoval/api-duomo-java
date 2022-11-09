package com.api.duomo.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regiones")
public class Region {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String region;

  /*@OneToOne(mappedBy = "region")
  private Persona persona;*/
 /* @OneToMany(fetch = FetchType.EAGER)
  private Set<Comuna> comunas = new HashSet<>();*/

  public Region() {
  }

  public Region(long id, String region) {
    this.id = id;
    this.region = region;

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }


}

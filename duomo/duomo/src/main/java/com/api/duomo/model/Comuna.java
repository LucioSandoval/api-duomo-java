package com.api.duomo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comunas")
public class Comuna {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String comuna;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "region_id")
  private Region region;

  /*@OneToOne(mappedBy = "comuna")
  private Persona persona;*/

  public Comuna() {
  }

  public Comuna(long id, String comuna, Region region) {
    this.id = id;
    this.comuna = comuna;
    this.region = region;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getComuna() {
    return comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }


}

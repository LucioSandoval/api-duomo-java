package com.api.duomo.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "personas")
public class Persona {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String nombre;
  private String apellido;
  private String Correo;
  private Date fechaNacimiento;
  private String telefono;

  @CreationTimestamp
  private Timestamp fechaCreacion;


  @JoinColumn(name = "comuna_id")
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  private Comuna comunaId;

  @JoinColumn(name = "region_id")
  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  private Region regionId;

  public Persona() {
  }

  public Persona(long id, String nombre, String apellido, String correo,
      Date fechaNacimiento, Timestamp fechaCreacion, String telefono, Region regionId, Comuna comuna) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    Correo = correo;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaCreacion = fechaCreacion;
    this.telefono = telefono;
    this.regionId = regionId;
    this.comunaId = comuna;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCorreo() {
    return Correo;
  }

  public void setCorreo(String correo) {
    Correo = correo;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public Timestamp getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Timestamp fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Region getRegionId() {
    return regionId;
  }

  public void setRegionId(Region regionId) {
    this.regionId = regionId;
  }

  public Comuna getComunaId() {
    return comunaId;
  }

  public void setComunaId(Comuna comunaId) {
    this.comunaId = comunaId;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}

package com.api.duomo.dto;

import com.api.duomo.model.Comuna;
import com.api.duomo.model.Region;
import com.api.duomo.validation.ValidationMessages;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PersonaDTO {

  private long id;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Pattern(regexp = ValidationMessages.REGEX_VALIDATION_STRING, message = ValidationMessages.REGEX_VALIDATION_STRING_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String nombre;

  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Pattern(regexp = ValidationMessages.REGEX_VALIDATION_STRING, message = ValidationMessages.REGEX_VALIDATION_STRING_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String apellido;

  @Email(message = ValidationMessages.REQUEST_PARAM_EMAIL_ERROR_MESSAGE)
  @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
  @Size(max = 250, message = ValidationMessages.REQUEST_PARAM_MAX_ERROR_MESSAGE)
  private String Correo;

  private Date fechaNacimiento;


  @Size(max = 25, message = ValidationMessages.REQUEST_PARAM_SIZE_MAX_ERROR_MESSAGE)
  private String telefono;


  private Region region;
  private Comuna comuna;

  public PersonaDTO() {
  }

  public PersonaDTO(long id, String nombre, String apellido, String correo,
      Date fechaNacimiento, String telefono,Region region, Comuna comuna) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    Correo = correo;
    this.fechaNacimiento = fechaNacimiento;
    this.telefono = telefono;
    this.region = region;
    this.comuna = comuna;
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


  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }

  public Comuna getComuna() {
    return comuna;
  }

  public void setComuna(Comuna comuna) {
    this.comuna = comuna;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}

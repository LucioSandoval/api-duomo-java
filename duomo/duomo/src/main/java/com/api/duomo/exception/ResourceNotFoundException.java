package com.api.duomo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoundException extends Exception{

  private static final long serialVersionUID = 1L;

  private String resourceName;
  private String fieldName;
  private long valueOfField;


  public ResourceNotFoundException() {
  }

  public ResourceNotFoundException(String resourceName, String fieldName, long valueOfField) {
    super(String.format("%s no encontrada con : %s : '%s'", resourceName, fieldName, valueOfField));

    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.valueOfField = valueOfField;
  }


}

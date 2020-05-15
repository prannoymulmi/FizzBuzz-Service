package com.prannoy.fizzbuzz.base;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
class ErrorDTO {

  private String errorTxt;
  private HttpStatus httpStatus;

  ErrorDTO(String errorTxt, HttpStatus httpStatus) {
    this.errorTxt = errorTxt;
    this.httpStatus = httpStatus;
  }

  ResponseEntity<ErrorDTO> createResponse() {
    return ResponseEntity.status(httpStatus).body(this);
  }

}

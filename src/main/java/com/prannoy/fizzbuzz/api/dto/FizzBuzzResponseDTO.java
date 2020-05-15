package com.prannoy.fizzbuzz.api.dto;

import lombok.Data;

@Data
public class FizzBuzzResponseDTO {

  private String result;

  public FizzBuzzResponseDTO(String result) {
    this.result = result;
  }
}

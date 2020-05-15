package com.prannoy.fizzbuzz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FizzBuzzRequestDTO {
  @Min(value = 1, message = "The number should be greater than 0")
  @NotNull(message = "Fizzbuzz cannot is required field and cannot be empty")
  private Integer fizzBuzzNumber;

}

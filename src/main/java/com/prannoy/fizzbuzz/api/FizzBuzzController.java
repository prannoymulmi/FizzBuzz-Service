package com.prannoy.fizzbuzz.api;

import com.prannoy.fizzbuzz.api.dto.FizzBuzzRequestDTO;
import com.prannoy.fizzbuzz.api.dto.FizzBuzzResponseDTO;
import com.prannoy.fizzbuzz.base.exception.FizzBuzzConstraintsViolationException;
import com.prannoy.fizzbuzz.service.FizzBuzzService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FizzBuzzController {

  private FizzBuzzService fizzBuzzService;

  @Autowired
  public FizzBuzzController(FizzBuzzService fizzBuzzService) {
    this.fizzBuzzService = fizzBuzzService;
  }

  @PostMapping("/fizzbuzz")
  public FizzBuzzResponseDTO processFizzBuzz(@RequestBody @Valid FizzBuzzRequestDTO fizzbuzzRequestDTO, Errors errors)
      throws FizzBuzzConstraintsViolationException {
    validateConstraintsErrors(errors);

    String result = fizzBuzzService
        .findFizzBuzzResult(fizzbuzzRequestDTO.getFizzBuzzNumber());
    return new FizzBuzzResponseDTO(result);
  }

  /**
   * Validates if all the fields constraints are met and interpolates the error message to be more readable
   * @param errors
   * @throws FizzBuzzConstraintsViolationException
   */
  private void validateConstraintsErrors(Errors errors)
      throws FizzBuzzConstraintsViolationException {
    if(errors.hasErrors()) {
      String message = errors.getFieldErrors().stream()
          .map(e -> e.getField() + ": " + e.getDefaultMessage() + "\r\n")
          .reduce("### Errors in the response for the following fields \r\n", String::concat);
      throw new FizzBuzzConstraintsViolationException(message);
    }
  }

}

package com.prannoy.fizzbuzz.base;

import com.prannoy.fizzbuzz.base.exception.FizzBuzzConstraintsViolationException;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@CommonsLog
public class ControllerExceptionHandler {

  /**
   * If un expected Errors occur, it will be handled here
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {Exception.class})
  @ResponseBody
  public ResponseEntity<ErrorDTO> generalError(Exception ex) {
    log.warn(ex.toString(), ex);
    return new ErrorDTO(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR).createResponse();
  }

  /**
   * This Handler
   * @param ex
   * @return
   */
  @ExceptionHandler(value = {FizzBuzzConstraintsViolationException.class})
  @ResponseBody
  public ResponseEntity<ErrorDTO> validationError(FizzBuzzConstraintsViolationException ex) {
    log.warn(ex.getMessage(), ex);
    return new ErrorDTO(ex.getMessage(), HttpStatus.BAD_REQUEST).createResponse();
  }
}

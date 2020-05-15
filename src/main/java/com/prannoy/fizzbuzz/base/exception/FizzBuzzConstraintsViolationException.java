package com.prannoy.fizzbuzz.base.exception;

/**
 * A custom exception which is used to catch constraint violations in the request DTO
 */
public class FizzBuzzConstraintsViolationException  extends Exception{
  private static final long serialVersionUID = 1L;

  public FizzBuzzConstraintsViolationException(String message) {
    super(message);
  }
}

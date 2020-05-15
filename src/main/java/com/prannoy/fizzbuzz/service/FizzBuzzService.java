package com.prannoy.fizzbuzz.service;

import org.springframework.stereotype.Service;

@Service
public class FizzBuzzService {

  public String findFizzBuzzResult(Integer input) {
    if (input % 3 == 0 && input % 5 == 0) {
      return "FizzBuzz";
    } else if (input % 5 == 0) {
      return "Buzz";
    } else if (input % 3 == 0) {
      return "Fizz";
    }
    return input.toString();
  }
}

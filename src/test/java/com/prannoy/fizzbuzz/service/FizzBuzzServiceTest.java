package com.prannoy.fizzbuzz.service;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.apachecommons.CommonsLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CommonsLog
class FizzBuzzServiceTest {


  private FizzBuzzService fizzBuzzService;

  @Autowired
  FizzBuzzServiceTest(FizzBuzzService fizzBuzzService) {
    this.fizzBuzzService = fizzBuzzService;
  }

  @Test
  void findFizzBuzzResult_DivisibleBy3_FizzAsResult() {
    String result = fizzBuzzService.findFizzBuzzResult(66);
    assertThat(result).isEqualToIgnoringCase("fizz");
  }


  @Test
  void findFizzBuzzResult_DivisibleBy5_BuzzAsResult() {
    String result = fizzBuzzService.findFizzBuzzResult(55);
    assertThat(result).isEqualToIgnoringCase("buzz");
  }


  @Test
  void findFizzBuzzResult_DivisibleBy3And5_FizzBuzzAsResult() {
    String result = fizzBuzzService.findFizzBuzzResult(30);
    assertThat(result).isEqualToIgnoringCase("fizzbuzz");
  }

  @Test
  void findFizzBuzzResult_NotDivisibleBy3And5_InputAsResult() {
    String result = fizzBuzzService.findFizzBuzzResult(89);
    assertThat(result).isEqualToIgnoringCase("89");
  }

}
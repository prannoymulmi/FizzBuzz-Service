package com.prannoy.fizzbuzz.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class FizzBuzzControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void processFizzBuzz_NumberDivisibleBy3_FizzReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": 3}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isOk())
        .andExpect(content().json("{"
            + "\"result\": \"Fizz\""
            + "}"));

  }


  @Test
  void processFizzBuzz_NumberDivisibleBy5_BuzzReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": 500}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isOk())
        .andExpect(content().json("{"
            + "\"result\": \"Buzz\""
            + "}"));

  }

  @Test
  void processFizzBuzz_NumberDivisibleBy3And5_FizzBuzzReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": 45}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isOk())
        .andExpect(content().json("{"
            + "\"result\": \"FizzBuzz\""
            + "}"));

  }

  @Test
  void processFizzBuzz_NumberNotDivisibleBy3And5_InputNumberReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": 13}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isOk())
        .andExpect(content().json("{"
            + "\"result\": \"13\""
            + "}"));

  }


  @Test
  void processFizzBuzz_Number0OrLessThan0_ErrorTextReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": -13}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isBadRequest())
        .andExpect(content().json(
            "{\"errorTxt\":\"### Errors in the response for the following fields \\r\\nfizzBuzzNumber: The number should be greater than 0\\r\\n\",\"httpStatus\":\"BAD_REQUEST\"}"));

  }

  @Test
  void processFizzBuzz_NumberIs0_ErrorTextReceived() throws Exception {
    String request = "{\"fizzBuzzNumber\": -1}";

    mockMvc.perform(
        MockMvcRequestBuilders.post("/fizzbuzz")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(request))
        .andExpect(status().isBadRequest())
        .andExpect(content().json(
            "{\"errorTxt\":\"### Errors in the response for the following fields \\r\\nfizzBuzzNumber: The number should be greater than 0\\r\\n\",\"httpStatus\":\"BAD_REQUEST\"}"));

  }

}
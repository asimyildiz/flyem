package com.flyem.microservice.controller;

import com.flyem.microservice.service.MockFlightGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller to mock data for search microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/mockflights")
public class MockFlightsController {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    MockFlightsController.class
  );

  /**
   * Represents the mock flight generation service object for search microservice
   * @since search-0.0.1-SNAPSHOT
   */
  private final MockFlightGenerationService dummyFlightGenerationService;

  /**
   * Represents the constructor of MockFlightsController with mock flight generation service
   * @param dummyFlightGenerationService mock flight generation service object
   * @since search-0.0.1-SNAPSHOT
   */
  public MockFlightsController(
    MockFlightGenerationService dummyFlightGenerationService
  ) {
    this.dummyFlightGenerationService = dummyFlightGenerationService;
  }

  /**
   * Handles /generatedummyflights request
   * @since search-0.0.1-SNAPSHOT
   */
  @GetMapping("/generatedummyflights")
  public void generateDummyFlights() {
    logger.info("called, generating mock flights data");
    dummyFlightGenerationService.generateFlights();
    logger.info("ended, mock flights data generated");
  }
}

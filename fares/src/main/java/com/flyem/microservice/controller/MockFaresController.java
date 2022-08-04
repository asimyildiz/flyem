package com.flyem.microservice.controller;

import com.flyem.microservice.service.MockFareGenerationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller to mock data for fares microservice
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/mockfares")
public class MockFaresController {

  /**
   * Represents the logger
   * @since fares-0.0.2-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    MockFaresController.class
  );

  /**
   * Represents the mock fare generation service object for fares microservice
   * @since fares-0.0.2-SNAPSHOT
   */
  private final MockFareGenerationService dummyFareGenerationService;

  /**
   * Represents the constructor of MockFaresController with mock fare generation service
   * @param dummyFareGenerationService mock fare generation service object
   * @since fares-0.0.2-SNAPSHOT
   */
  public MockFaresController(
    MockFareGenerationService dummyFareGenerationService
  ) {
    this.dummyFareGenerationService = dummyFareGenerationService;
  }

  /**
   * Handles /generatedummyfares request
   * @since fares-0.0.2-SNAPSHOT
   */
  @GetMapping("/generatedummyfares")
  public void generateDummyFares() {
    logger.info("called, generating mock fares data");
    dummyFareGenerationService.generateFares();
    logger.info("ended, mock fares data generated");
  }
}

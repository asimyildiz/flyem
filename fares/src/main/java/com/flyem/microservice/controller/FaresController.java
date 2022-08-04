package com.flyem.microservice.controller;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.service.FaresQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller for fares microservice
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
@RestController
@RequestMapping(value = "/fares")
public class FaresController {

  /**
   * Represents the logger
   * @since fares-0.0.2-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    FaresController.class
  );

  /**
   * Represents the querying service object for fares microservice
   * @since fares-0.0.2-SNAPSHOT
   */
  private final FaresQueryService faresQueryService;

  /**
   * Represents the constructor of FaresController with querying service
   * @param faresQueryService querying service object
   * @since fares-0.0.2-SNAPSHOT
   */
  public FaresController(FaresQueryService faresQueryService) {
    this.faresQueryService = faresQueryService;
  }

  /**
   * Handles /getFare request
   * @param flightNumber flight number
   * @param flightDate flight date
   * @return Fare response
   * @since fares-0.0.2-SNAPSHOT
   */
  @GetMapping("/getFare")
  @ResponseBody
  public Fare getFare(
    @RequestParam(name = "flightNumber", required = true) String flightNumber,
    @RequestParam(name = "flightDate", required = true) String flightDate
  ) {
    logger.info(
      "called, with flightNumber: {}, flightDate: {}",
      flightNumber,
      flightDate
    );
    Fare response = faresQueryService.getFare(flightNumber, flightDate);
    logger.info("ended, with response => {}", response);
    return response;
  }
}

package com.flyem.microservice.service;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.domain.repository.FaresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Represents the query service for fares microservice
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
@Service
public class FaresQueryService {

  /**
   * Represents the logger
   * @since fares-0.0.2-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    FaresQueryService.class
  );

  /**
   * Represents the fares repository
   * @since fares-0.0.2-SNAPSHOT
   */
  @Autowired
  private FaresRepository faresRepository;

  /**
   * Search for fare data for a flight on a given date on the repository
   * @param flightNumber flight number
   * @param flightDate flight date
   * @return Fare result
   * @since fares-0.0.2-SNAPSHOT
   */
  public Fare getFare(String flightNumber, String flightDate) {
    logger.info(
      "called, with parameters flightNumber: {}, flightDate: {}",
      flightNumber,
      flightDate
    );
    Fare fare = faresRepository.getFareByFlightNumberAndFlightDate(
      flightNumber,
      flightDate
    );
    logger.info("ended, with data => {}", fare);
    return fare;
  }
}

package com.flyem.microservice.service;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.domain.repository.FaresRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Represents the mock fare generation service for fares microservice
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
@Service
public class MockFareGenerationService {

  /**
   * Represents the logger
   * @since fares-0.0.2-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    MockFareGenerationService.class
  );

  /**
   * Represents the fares repository
   * @since fares-0.0.2-SNAPSHOT
   */
  @Autowired
  private FaresRepository faresRepository;

  /**
   * Represents the method to generate mock fare data for fares microservice
   * and save it to H2 database
   * @since fares-0.0.2-SNAPSHOT
   */
  public void generateFares() {
    logger.info("called, generating mock fares data");
    Fare[] fares = {
      Fare
        .builder()
        .flightNumber("FM100")
        .flightDate("01-09-22")
        .amount(200.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM101")
        .flightDate("01-09-22")
        .amount(180.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM102")
        .flightDate("01-09-22")
        .amount(150.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM200")
        .flightDate("02-09-22")
        .amount(110.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM201")
        .flightDate("02-09-22")
        .amount(100.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM300")
        .flightDate("03-09-22")
        .amount(120.0)
        .currency("USD")
        .build(),
      Fare
        .builder()
        .flightNumber("FM301")
        .flightDate("03-09-22")
        .amount(100.0)
        .currency("USD")
        .build(),
    };
    logger.info("generated, mock fares data generated");
    List<Fare> list = Arrays.stream(fares).collect(Collectors.toList());
    list.forEach(fare -> faresRepository.save(fare));
    logger.info("ended, mock fares data saved into H2 database");
  }
}

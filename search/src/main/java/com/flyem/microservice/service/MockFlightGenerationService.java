package com.flyem.microservice.service;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.domain.entity.Flight;
import com.flyem.microservice.domain.entity.Inventory;
import com.flyem.microservice.domain.repository.FlightRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Represents the mock flight generation service for search microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Service
public class MockFlightGenerationService {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    MockFlightGenerationService.class
  );

  /**
   * Represents the flight repository
   * @since search-0.0.1-SNAPSHOT
   */
  @Autowired
  private FlightRepository flightRepository;

  /**
   * Represents the method to generate mock flight data for search microservice
   * and save it to H2 database
   * @since search-0.0.1-SNAPSHOT
   */
  public void generateFlights() {
    logger.info("called, generating mock flights data");
    Flight[] flights = {
      Flight.builder()
        .flightNumber("FM100")
        .flightDate("01-09-22")
        .origin("LAX")
        .destination("DXB")
        .fare(new Fare(200.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM101")
        .flightDate("01-09-22")
        .origin("DXB")
        .destination("LCY")
        .fare(new Fare(180.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM102")
        .flightDate("01-09-22")
        .origin("IST")
        .destination("DXB")
        .fare(new Fare(150.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM200")
        .flightDate("02-09-22")
        .origin("DXB")
        .destination("CFK")
        .fare(new Fare(110.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM201")
        .flightDate("02-09-22")
        .origin("LHR")
        .destination("DXB")
        .fare(new Fare(100.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM300")
        .flightDate("03-09-22")
        .origin("CDG")
        .destination("DXB")
        .fare(new Fare(120.0, "USD"))
        .inventory(new Inventory(25))
        .build(),
      Flight.builder()
        .flightNumber("FM300")
        .flightDate("03-09-22")
        .origin("DXB")
        .destination("RUH")
        .fare(new Fare(100.0, "USD"))
        .inventory(new Inventory(25))
        .build()
    };
    
    logger.info("generated, mock flights data generated");
    List<Flight> list = Arrays.stream(flights).collect(Collectors.toList());
    list.forEach(flight -> flightRepository.save(flight));
    logger.info("ended, mock flights data saved into H2 database");
  }
}

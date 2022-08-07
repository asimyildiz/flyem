package com.flyem.microservice.controller;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.exception.ResourceNotFoundException;
import com.flyem.microservice.service.FaresQueryService;
import com.flyem.microservice.component.Sender;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
   * Represents the RabbitMq sender object
   * @since fares-0.0.4-SNAPSHOT
   */
  private final Sender sender;

  /**
   * Represents the constructor of FaresController with querying service
   * @param faresQueryService querying service object
   * @param sender RabbitMq sender object
   * @since fares-0.0.2-SNAPSHOT
   */
  public FaresController(FaresQueryService faresQueryService, Sender sender) {
    this.faresQueryService = faresQueryService;
    this.sender = sender;
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

  /**
   * Handles PUT request for fares with id
   * @param fareId fare id
   * @param Fare fare data
   * @return ResponseEntity
   * @since fares-0.0.4-SNAPSHOT
   */
  @PutMapping("/{id}")
  public ResponseEntity<Fare> updateFare(
    @PathVariable(value = "id") Long fareId,
    @Valid @RequestBody Fare fare
  )
    throws ResourceNotFoundException {
    logger.info("called, to update fare with id: {}", fareId);
    Fare data = faresQueryService
      .getFare(fareId)
      .orElseThrow(
        () -> new ResourceNotFoundException("Fare not exist with id: " + fareId)
      );

    logger.info("found, fare data found and updating: {}", data);
    data.setAmount(fare.getAmount());
    data.setCurrency(fare.getCurrency());

    faresQueryService.save(data);    

    sender.send(data.toMap());   
    logger.info("ended, fare data updated and sending: {}", data); 
    return ResponseEntity.ok(data);
  }
}

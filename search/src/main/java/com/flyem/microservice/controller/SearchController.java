package com.flyem.microservice.controller;

import com.flyem.microservice.domain.entity.Flight;
import com.flyem.microservice.models.FlightQuery;
import com.flyem.microservice.service.FlightQueryService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents the controller for search microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/search")
public class SearchController {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    SearchController.class
  );

  /**
   * Represents the querying service object for search microservice
   * @since search-0.0.1-SNAPSHOT
   */
  private final FlightQueryService flightQueryService;

  /**
   * Represents the constructor of SearchController with querying service
   * @param flightQueryService querying service object
   * @since search-0.0.1-SNAPSHOT
   */
  public SearchController(FlightQueryService flightQueryService) {
    this.flightQueryService = flightQueryService;
  }

  /**
   * Handles /flights request
   * @param searchQuery query data
   * @return List<Flight> response, list of flights found
   * @since search-0.0.1-SNAPSHOT
   */
  @PostMapping("/flights")
  @ResponseBody
  public List<Flight> search(@RequestBody FlightQuery query) {
    logger.info("called, with query: {}", query);
    List<Flight> response = flightQueryService.search(query);
    logger.info("ended, with response => {}", response);
    return response;
  }
}

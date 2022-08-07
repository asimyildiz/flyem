package com.flyem.microservice.service;

import com.flyem.microservice.domain.entity.Fare;
import com.flyem.microservice.domain.entity.Flight;
import com.flyem.microservice.domain.entity.Inventory;
import com.flyem.microservice.domain.repository.FlightRepository;
import com.flyem.microservice.models.FlightQuery;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Represents the query service for search microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Service
public class FlightQueryService {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(
    FlightQueryService.class
  );

  /**
   * Represents the flight repository
   * @since search-0.0.1-SNAPSHOT
   */
  @Autowired
  private FlightRepository flightRepository;

  /**
   * Search for flights using a query passed to this method, from flight repository
   * If the flight does not have any empty seat, it will be removed from result list
   * @param query flight query data
   * @return Flights found
   * @since search-0.0.1-SNAPSHOT
   */
  public List<Flight> search(FlightQuery query) {
    logger.info("called, with parameters flightQuery: {}", query);
    List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(
      query.getOrigin(),
      query.getDestination(),
      query.getFlightDate()
    );
    logger.info("queried, result data: {}", flights);

    logger.info("filtering, result is being filtered");
    // we can use Guava (but just to use it here once, no need to add a new package) or,
    // we can use removeIf method with a Predicate but I wanted to copy the list and filter it there
    List<Flight> result = new ArrayList<>(flights);
    result.forEach(
      flight -> {
        if (flight.getInventory().getCount() <= 0) {
          result.remove(flight);
        }
      }
    );
    logger.info("ended, result is filtered: {}", result);
    return result;
  }

  /**
   * Update fare data for a flight
   * @param flightNumber flight number data
   * @param flightDate flight date data
   * @param amount amount data
   * @param currency currency data
   * @since search-0.0.1-SNAPSHOT
   */
  public void updateFare(
    String flightNumber,
    String flightDate,
    double amount,
    String currency
  ) {
    logger.info(
      "called, with parameters flightNumber: {}, flightDate: {}, amount: {}, currency: {}",
      flightNumber,
      flightDate,
      amount,
      currency
    );
    Flight flight = flightRepository.findByFlightNumberAndFlightDate(
      flightNumber,
      flightDate
    );
    logger.info("queried, result data: {}", flight);

    Fare fare = flight.getFare();
    logger.info(
      "updating, fare data: {} with amount: {}, currency: {}",
      fare,
      amount,
      currency
    );
    fare.setAmount(amount);
    fare.setCurrency(currency);
    flightRepository.save(flight);
    logger.info("ended, repository updated");
  }

  /**
   * Update inventory data for a flight
   * @param flightNumber flight number data
   * @param flightDate flight date data
   * @param count inventory count data
   * @since search-0.0.1-SNAPSHOT
   */
  public void updateInventory(
    String flightNumber,
    String flightDate,
    int count
  ) {
    logger.info(
      "called, with parameters flightNumber: {}, flightDate: {}, count: {}",
      flightNumber,
      flightDate,
      count
    );
    Flight flight = flightRepository.findByFlightNumberAndFlightDate(
      flightNumber,
      flightDate
    );
    logger.info("queried, result data: {}", flight);

    Inventory inventory = flight.getInventory();
    logger.info(
      "updating, inventory data: {} with count: {}",
      inventory,
      count
    );
    inventory.setCount(count);
    flightRepository.save(flight);
    logger.info("ended, repository updated");
  }
}

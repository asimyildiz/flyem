package com.flyem.microservice.domain.repository;

import com.flyem.microservice.domain.entity.Flight;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents the repository interface for search microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
public interface FlightRepository extends JpaRepository<Flight, Long> {
  /**
   * Represents the method to get list of flights by querying database using origin, destination and flightDate
   * @param origin origin to query database with
   * @param destination destination to query database with
   * @param flightDate flight date to query database with
   * @return list of Flight data
   * @since search-0.0.1-SNAPSHOT
   */
  List<Flight> findByOriginAndDestinationAndFlightDate(
    String origin,
    String destination,
    String flightDate
  );

  /**
   * Represents the method to get a flights by querying database using flightNumber and flightDate
   * @param flightNumber flight number to query database with
   * @param flightDate flight date to query database with
   * @return Flight data
   * @since search-0.0.1-SNAPSHOT
   */
  Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}

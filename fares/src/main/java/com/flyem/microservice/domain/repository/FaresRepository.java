package com.flyem.microservice.domain.repository;

import com.flyem.microservice.domain.entity.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents the repository interface for fares microservice
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
public interface FaresRepository extends JpaRepository<Fare, Long> {
  /**
   * Represents the method to get a fare by querying database using flightNumber and flightDate
   * @param flightNumber flightNumber to query database with
   * @param flightDate flightDate to query database with
   * @return Fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  Fare findByFlightNumberAndFlightDate(
    String flightNumber,
    String flightDate
  );
}

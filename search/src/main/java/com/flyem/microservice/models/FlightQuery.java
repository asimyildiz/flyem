package com.flyem.microservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlightQuery {

  /**
   * Represents the origin data to be used with query service
   * @since search-0.0.1-SNAPSHOT
   */
  private String origin;

  /**
   * Represents the destination data to be used with query service
   * @since search-0.0.1-SNAPSHOT
   */
  private String destination;

  /**
   * Represents the flight date to be used with query service
   * @since search-0.0.1-SNAPSHOT
   */
  private String flightDate;
}

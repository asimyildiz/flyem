package com.flyem.microservice.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a Flight Model
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "flight")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {

  /**
   * Represents the id of flight data
   * id field is generated automatically
   * @since search-0.0.1-SNAPSHOT
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_generator")
  @SequenceGenerator(name = "flight_generator", sequenceName = "flight_seq", allocationSize = 1)
  @ToString.Exclude
  @Setter(AccessLevel.PROTECTED)
  private Long id;

  /**
   * Represents the flight number of flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @NonNull
  private String flightNumber;

  /**
   * Represents the flight date of flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @NonNull
  private String flightDate;

  /**
   * Represents the origin airport of flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @NonNull
  private String origin;

  /**
   * Represents the destination airport of flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @NonNull
  private String destination;

  /**
   * Represents the fare data for flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "fare_id")
  @NonNull
  Fare fare;

  /**
   * Represents the inventory data for flight data
   * @since search-0.0.1-SNAPSHOT
   */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "inventory_id")
  @NonNull
  Inventory inventory;
}

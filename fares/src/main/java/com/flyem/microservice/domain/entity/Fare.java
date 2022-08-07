package com.flyem.microservice.domain.entity;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Represents Fare Model
 * @author ASIM YILDIZ
 * @version fares-0.0.2-SNAPSHOT
 * @since fares-0.0.2-SNAPSHOT
 */
@Entity
@Table(name = "fare")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fare {

  /**
   * Represents the id of fare data
   * id field is generated automatically
   * @since fares-0.0.2-SNAPSHOT
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ToString.Exclude
  private Long id;

  /**
   * Represents the flight number of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @NonNull
  private String flightNumber;

  /**
   * Represents the flight date of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @NonNull
  private String flightDate;

  /**
   * Represents the amount of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @NotEmpty
  private double amount;

  /**
   * Represents the currency of the amount
   * @since fares-0.0.3-SNAPSHOT
   */
  @NonNull
  private String currency;

  /**
   * Represent toMap method to generate an object sendable by RabbitMq
   * @return fareMessage map
   * @since fares-0.0.4-SNAPSHOT
   */
  public Map<String, Object> toMap() {
    Map<String, Object> fareMessage = new HashMap<>();
    fareMessage.put("FLIGHT_NUMBER", flightNumber);
    fareMessage.put("FLIGHT_DATE", flightDate);
    fareMessage.put("AMOUNT", amount);
    fareMessage.put("CURRENCY", currency);
    return fareMessage;
  }
}

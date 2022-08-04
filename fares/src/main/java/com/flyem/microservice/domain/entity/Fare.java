package com.flyem.microservice.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
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
  @Getter
  @Setter
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Represents the flight number of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @Getter
  @Setter
  @NonNull
  private String flightNumber;

  /**
   * Represents the flight date of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @Getter
  @Setter
  @NonNull
  private String flightDate;

  /**
   * Represents the amount of fare data
   * @since fares-0.0.2-SNAPSHOT
   */
  @Getter
  @Setter
  @NotEmpty
  private double amount;

  /**
   * Represents the currency of the amount
   * @since fares-0.0.3-SNAPSHOT
   */
  @Getter
  @Setter
  @NonNull
  private String currency;
}

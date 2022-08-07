package com.flyem.microservice.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Represents a simplified Fare Model
 * Fare Model is actually an entity of Fare Microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "fare")
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Fare {
  
  /**
   * Represents the id of fare data
   * id field is generated automatically
   * @since search-0.0.1-SNAPSHOT
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fare_generator")
  @SequenceGenerator(name = "fare_generator", sequenceName = "fare_seq", allocationSize = 1)
  @Column(name = "fare_id")
  @ToString.Exclude
  @Setter(AccessLevel.PROTECTED)
  private Long id;

  /**
   * Represents the amount of fare data
   * @since search-0.0.1-SNAPSHOT
   */
  // NonNull does not work for primitives. No null-check will be generated for it by lombok.
  // This is added just to create a RequiredArgsContructor 
  @NonNull
  @NotEmpty  
  private double amount;

  /**
   * Represents the currency of the amount
   * @since search-0.0.1-SNAPSHOT
   */
  @NonNull
  private String currency;
}

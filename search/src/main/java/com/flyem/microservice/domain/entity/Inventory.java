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
 * Represents a simplified Inventory Model
 * Inventory Model is actually an entity of Booking Microservice
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "inventory")
@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Inventory {

  /**
   * Represents the id of inventory data
   * id field is generated automatically
   * @since search-0.0.1-SNAPSHOT
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory_generator")
  @SequenceGenerator(name = "inventory_generator", sequenceName = "inventory_seq", allocationSize = 1)
  @Column(name = "inventory_id")
  @ToString.Exclude
  @Setter(AccessLevel.PROTECTED)
  private Long id;

  /**
   * Represents the count of inventory data
   * @since search-0.0.1-SNAPSHOT
   */
  // NonNull does not work for primitives. No null-check will be generated for it by lombok.
  // This is added just to create a RequiredArgsContructor
  @NonNull
  @NotEmpty
  private int count;
}

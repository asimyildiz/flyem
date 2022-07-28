package com.flyem.service.greeting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Represents Greeting Model
 * @author ASIM YILDIZ
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@ToString
@AllArgsConstructor
public class Greeting {

  /**
   * Represents the id of a Greeting Request
   */
  @Getter
  private final long id;

  /**
   * Represents the content of a Greeting Request
   */
  @Getter
  @NonNull
  private final String content;
}

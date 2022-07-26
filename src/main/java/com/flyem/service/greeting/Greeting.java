package com.flyem.service.greeting;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Greeting {

  @Getter
  private final long id;

  @Getter
  @NonNull
  private final String content;
}

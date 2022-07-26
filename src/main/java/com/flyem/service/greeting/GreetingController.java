package com.flyem.service.greeting;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

  private static final String template = "Hello from service: %s";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  @ResponseBody
  public Greeting sayHello(
    @RequestParam(
      name = "name",
      required = false,
      defaultValue = "Anonymous"
    ) String name
  ) {
    return new Greeting(
      counter.incrementAndGet(),
      String.format(template, name)
    );
  }
}

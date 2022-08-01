package com.flyem.service.greeting;

import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Represents Greeting Controller for Greeting Service
 * @author ASIM YILDIZ
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1-SNAPSHOT
 */
@Controller
public class GreetingController {

  /**
   * Represents the logger
   */
  private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
  /**
   * Represents the static template message that Greeting Service uses
   */
  private static final String template = "Hello from service: %s";
  /**
   * Represents the counter the Greeting Service uses for id property
   */
  private final AtomicLong counter = new AtomicLong();

  /**
   * Handles /greeting request
   * 
   * @param name Request parameter
   * @return Greeting response
   * @since 0.0.1-SNAPSHOT
   */
  @GetMapping("/greeting")
  @ResponseBody
  public Greeting sayHello(
    @RequestParam(
      name = "name",
      required = false,
      defaultValue = "Anonymous"
    ) String name
  ) {
    log.info("Inside /greeting handler function");
    Greeting response = new Greeting(
      counter.incrementAndGet(),
      String.format(template, name)
    );
    log.info("Response => {}", response);
    return response;
  }
}

package com.flyem.microservice.component;

import com.flyem.microservice.service.FlightQueryService;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Represents the Receiver class for search microservice
 * that is being used to listen messages using RabbitMq
 * @author ASIM YILDIZ
 * @version search-0.0.1-SNAPSHOT
 * @since search-0.0.1-SNAPSHOT
 */
@Component
public class Receiver {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

  /**
   * Represents the querying service object for search microservice
   * @since search-0.0.1-SNAPSHOT
   */
  private final FlightQueryService flightQueryService;

  /**
   * Represents the constructor of Receiver with querying service
   * @param flightQueryService querying service object
   * @since search-0.0.1-SNAPSHOT
   */
  public Receiver(FlightQueryService flightQueryService) {
    this.flightQueryService = flightQueryService;
  }

  /**
   * queue name to listen
   * @return current Queue name
   * @since search-0.0.1-SNAPSHOT
   */
  @Bean
  Queue queue() {
    return new Queue("SearchQ", false);
  }

  /**
   * process message on SearchQ
   * @param fare fare data on queue
   * @since search-0.0.1-SNAPSHOT
   */
  @RabbitListener(queues = "SearchQ")
  public void processMessage(Map<String, Object> fare) {
    logger.info("called, processing message on SearchQ with data: {}", fare);
    flightQueryService.updateFare(
      fare.get("FLIGHT_NUMBER").toString(),
      fare.get("FLIGHT_DATE").toString(),
      Double.parseDouble(fare.get("AMOUNT").toString()),
      fare.get("CURRENCY").toString()
    );
    logger.info("ended, fare updated for a flight");
  }
}

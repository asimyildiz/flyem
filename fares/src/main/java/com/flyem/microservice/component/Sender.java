package com.flyem.microservice.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Represents the Sender class for fares microservice
 * that is being used to send messages using RabbitMq
 * @author ASIM YILDIZ
 * @version fares-0.0.4-SNAPSHOT
 * @since fares-0.0.4-SNAPSHOT
 */
@Component
public class Sender {

  /**
   * Represents the logger
   * @since search-0.0.1-SNAPSHOT
   */
  private static final Logger logger = LoggerFactory.getLogger(Sender.class);

  /**
   * Represents the name of search queue
   */
  private static final String SEARCH_QUEUE = "SearchQ";

  /**
   * Represents the messaging template
   * @since fares-0.0.4-SNAPSHOT
   */
  @Autowired
  RabbitMessagingTemplate template;

  /**
   * bean that returns the queue to operate on
   * if there are multiple queues then queue1 etc. needs to be defined
   * @return queue
   * @since fares-0.0.4-SNAPSHOT
   */
  @Bean
  Queue queue() {
    return new Queue(SEARCH_QUEUE, false);
  }

  /**
   * Represents the method that sends a message to current queue
   * @since fares-0.0.4-SNAPSHOT
   */
  public void send(Object message) {
    logger.info("called, message is being send to queue: {} with data: {}", SEARCH_QUEUE, message);
    template.convertAndSend(SEARCH_QUEUE, message);
  }
}

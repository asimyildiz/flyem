package com.flyem.service;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = { "management.port=0" })
class FaresApplicationTests {

  @Value("${local.management.port}")
  private int managementPort;

  @Autowired
  private TestRestTemplate testRestTemplate;

  @Test
  void shouldReturn200ForManagementEndpoint() throws Exception {
    @SuppressWarnings("rawtypes")
    ResponseEntity<Map> entity =
      this.testRestTemplate.getForEntity(
          "http://localhost:" + this.managementPort + "/actuator",
          Map.class
        );
    then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  }
}

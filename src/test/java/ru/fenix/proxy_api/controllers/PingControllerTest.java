package ru.fenix.proxy_api.controllers;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PingControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void pingGet() {

        ResponseEntity<String> response = restTemplate.getForEntity("/ping", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext context = JsonPath.parse(response.getBody());

        String version = context.read("$.version");
        assertThat(version).isNotNull();

    }

    @Test
    void pingPost() {
        ResponseEntity<String> response = restTemplate.postForEntity("/ping", null, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext context = JsonPath.parse(response.getBody());

        String version = context.read("$.version");
        assertThat(version).isNotNull();
        assertThat(version).isNotEqualTo("pong");

    }
}
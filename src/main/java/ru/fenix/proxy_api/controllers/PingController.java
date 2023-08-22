package ru.fenix.proxy_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ping")
public class PingController {

    Map<String, String> version = new HashMap<>();

    @GetMapping
    public ResponseEntity<Map<String, String>> pingGet() {
        setVersion();
        return ResponseEntity.ok(version);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> pingPost() {
        setVersion();
        return ResponseEntity.ok(version);
    }

    private void setVersion() {
        version.put("version", "0.0.1");
    }

}

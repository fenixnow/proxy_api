package ru.fenix.proxy_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fenix.proxy_api.entities.Version;

@RestController
@RequestMapping("/ping")
public class PingController {

    Version version = new Version("0.0.1");

    @GetMapping
    public ResponseEntity<Version> pingGet() {
        return ResponseEntity.ok(version);
    }

    @PostMapping
    public ResponseEntity<Version> pingPost() {
        return ResponseEntity.ok(version);
    }
}

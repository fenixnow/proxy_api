package ru.fenix.proxy_api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MessagesController {

    @GetMapping("/message")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<String>> getMessage() {
        return ResponseEntity.ok(Arrays.asList("Первый", "Vtoroy"));
    }
}

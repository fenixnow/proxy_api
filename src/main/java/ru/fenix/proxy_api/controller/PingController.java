package ru.fenix.proxy_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public ResponseEntity ping() {

        Map<String, String> map = new HashMap<>();
        map.put("version", "0.1");

        try {
            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }
}

package ru.fenix.proxy_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fenix.proxy_api.exception.ShopNumberNotFoundException;
import ru.fenix.proxy_api.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity getAuth(@RequestHeader Long shopNumber, @RequestParam String code) {
        try {

            return ResponseEntity.ok(authenticationService.auth(shopNumber, code));
        } catch (ShopNumberNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}

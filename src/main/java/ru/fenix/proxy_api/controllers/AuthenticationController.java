package ru.fenix.proxy_api.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fenix.proxy_api.dtos.CredentialsDto;
import ru.fenix.proxy_api.dtos.UserDto;
import ru.fenix.proxy_api.exceptions.ShopNumberNotFoundException;
import ru.fenix.proxy_api.services.AuthenticationService;
import ru.fenix.proxy_api.services.UserService;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private AuthenticationService authenticationService;
    private final UserService userService;

    @GetMapping("/auth")
    public ResponseEntity getAuth(@RequestHeader Long shopNumber, @RequestParam String code) {
        try {

            return ResponseEntity.ok(authenticationService.auth(shopNumber, code));
        } catch (ShopNumberNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto credentialDto) {
        UserDto userDto = userService.login(credentialDto);
        return ResponseEntity.ok(userDto);
    }

}

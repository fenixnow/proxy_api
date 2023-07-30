package ru.fenix.proxy_api.controllers.catalogs;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fenix.proxy_api.entities.catalogs.ShopEntity;
import ru.fenix.proxy_api.services.ShopService;

@RestController
@RequestMapping("catalogs/shops")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/create")
    public ResponseEntity createShop(@RequestBody ShopEntity shop, @RequestHeader Integer shopNumber) {
        // Вот тут нужно проверить, что авторизация успешная, токен актуален

        try {
            return ResponseEntity.ok(shopService.createShop(shop));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity deleteShop(@PathVariable Integer id) {
        return ResponseEntity.ok(shopService.deleteShop(id));
    }
}

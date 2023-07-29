package ru.fenix.proxy_api.controller.catalogs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fenix.proxy_api.entity.catalogs.ShopEntity;
import ru.fenix.proxy_api.service.ShopService;

@RestController
@RequestMapping("catalogs/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ResponseEntity createShop(@RequestBody ShopEntity shop, @RequestHeader Integer shopNumber) {
        // Вот тут нужно проверить, что авторизация успешная, токен актуален

        try {
            return ResponseEntity.ok(shopService.createShop(shop));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error");
        }
    }
}

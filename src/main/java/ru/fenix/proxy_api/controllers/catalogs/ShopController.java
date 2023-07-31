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

    @PostMapping()
    public ResponseEntity<ShopEntity> createShop(@RequestBody ShopEntity shop, @RequestHeader Integer shopNumber) {
        // Вот тут нужно проверить, что авторизация успешная, токен актуален

        try {
            return ResponseEntity.ok(shopService.createShop(shop));
        } catch (Exception e) {
//            return ResponseEntity.badRequest().body("error");
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{shopNumber}")
    public ResponseEntity<ShopEntity> getShop(Long shopNumber) {
        ShopEntity shop = shopService.findByNumber(shopNumber);

        // чтобы не ругалось, думаю нужно делать через попытку
        if (shop != null) {
            return ResponseEntity.ok(shop);
        }
//        return ResponseEntity.badRequest().body(String.format("Торговая точка с номером {} не найдена.", shopNumber));
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{shopNumber}")
    public ResponseEntity<String> updateShop(@PathVariable Long shopNumber) {
        return ResponseEntity.ok("Метод не реализован");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteShop(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.deleteShop(id));
    }
}

//C - POST
//R - GET
//U - PUT
//D - DELETE
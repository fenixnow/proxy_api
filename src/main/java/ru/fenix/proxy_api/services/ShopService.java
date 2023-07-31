package ru.fenix.proxy_api.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fenix.proxy_api.entities.catalogs.ShopEntity;
import ru.fenix.proxy_api.exception.ShopAlreadyExistException;
import ru.fenix.proxy_api.repositories.ShopRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopEntity createShop(ShopEntity shop) throws ShopAlreadyExistException {
        if (shopRepository.findByShopNumber(shop.getShopNumber()) != null) {
            throw new ShopAlreadyExistException("Торговая точка с таким номером уже существует.");
        }
        return shopRepository.save(shop);
    }

    public ShopEntity findByNumber(Long shopNumber) {

        return shopRepository.findByShopNumber(shopNumber);
    }

    public String deleteShop(Long id) {
        ShopEntity shop = shopRepository.findById(id).orElse(null);

        if (shop != null) {
            shopRepository.delete(shop);
        } else {
            log.error("магазин с номером {} не найден.", id);
        }

        return "success";
    }
}

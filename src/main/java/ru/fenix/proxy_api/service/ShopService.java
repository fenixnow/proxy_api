package ru.fenix.proxy_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fenix.proxy_api.entity.catalogs.ShopEntity;
import ru.fenix.proxy_api.exception.ShopAlreadyExistException;
import ru.fenix.proxy_api.repository.ShopRepo;

@Service
public class ShopService {

    @Autowired
    private ShopRepo shopRepo;

    public ShopEntity createShop(ShopEntity shop) throws ShopAlreadyExistException {
        if (shopRepo.findByShopNumber(shop.getShopNumber()) != null) {
            throw new ShopAlreadyExistException("Торговая точка с таким номером уже существует.");
        }
        return shopRepo.save(shop);
    }
}

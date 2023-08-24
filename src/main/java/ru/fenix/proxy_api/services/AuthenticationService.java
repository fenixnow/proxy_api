package ru.fenix.proxy_api.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fenix.proxy_api.entities.catalogs.ShopEntity;
import ru.fenix.proxy_api.exceptions.ShopNumberNotFoundException;
import ru.fenix.proxy_api.repositories.ShopRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final ShopRepository shopRepo;

    public Boolean auth(Long shopNumber, String code) throws ShopNumberNotFoundException {
        String currentCode = getShop(shopNumber).getCode();

        return Objects.equals(currentCode, code);
    }

    private ShopEntity getShop(Long shopNumber) throws ShopNumberNotFoundException {

        ShopEntity shop = shopRepo.findByShopNumber(shopNumber);
        if ( shop == null) {
            throw new ShopNumberNotFoundException(String.format("Торговая точка с номером %2d не найдена.", shopNumber));
        }

        return shop;
    }
}

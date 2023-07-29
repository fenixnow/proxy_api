package ru.fenix.proxy_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenix.proxy_api.entity.catalogs.ShopEntity;

public interface ShopRepo extends CrudRepository<ShopEntity, Integer> {
    ShopEntity findByShopNumber(Integer shopNumber);
}

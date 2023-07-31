package ru.fenix.proxy_api.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.fenix.proxy_api.entities.catalogs.ShopEntity;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
    ShopEntity findByShopNumber(Long shopNumber);
}

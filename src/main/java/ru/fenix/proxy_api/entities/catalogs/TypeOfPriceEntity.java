package ru.fenix.proxy_api.entities.catalogs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TypeOfPriceEntity {

    @Id
    private Long id;
    private String name;
    private String priceId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

package ru.fenix.proxy_api.entity.catalogs;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TypeOfPrice {
    @Id
    private Long id;
    private String title;
    private String priceId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

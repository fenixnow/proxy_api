package ru.fenix.proxy_api.entity.catalogs;

import jakarta.persistence.*;

@Entity
@Table(name = "shops")
public class Shops {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer shopNumber;
    private TypeOfPrice typePrice;

    protected Shops() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

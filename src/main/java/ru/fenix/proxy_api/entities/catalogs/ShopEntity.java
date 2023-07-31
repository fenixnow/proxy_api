package ru.fenix.proxy_api.entities.catalogs;

import jakarta.persistence.*;

@Entity
@Table(name = "shops")
public class ShopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, updatable = false)
    private Long shopNumber;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToOne
    @JoinColumn(name = "id")
    private TypeOfPriceEntity typeOfPrice;

    protected ShopEntity() {}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(Long shopNumber) {
        this.shopNumber = shopNumber;
    }

    public TypeOfPriceEntity getTypeOfPrice() {
        return typeOfPrice;
    }

    public void setTypeOfPrice(TypeOfPriceEntity typeOfPrice) {
        this.typeOfPrice = typeOfPrice;
    }

    public Long getId() {
        return id;
    }
}

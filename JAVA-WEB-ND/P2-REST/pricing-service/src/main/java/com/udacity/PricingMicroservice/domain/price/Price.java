package com.udacity.PricingMicroservice.domain.price;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents the price of a given vehicle, including currency.
 */

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal price;
    private String currency;

    public Price() {
    }

    public Price(Long id, BigDecimal price, String currency) {
        this.id = id;
        this.price = price;
        this.currency = currency;

    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getVehicleId() {
        return id;
    }

    public void setVehicleId(Long vehicleId) {
        this.id = vehicleId;
    }
}

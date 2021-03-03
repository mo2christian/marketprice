package com.onepointgroup.pricing.core;

import java.math.BigDecimal;

public class DiscountPrice {

    private final Unit unit;
    private final double quantity;
    private final BigDecimal price;

    public DiscountPrice(Unit unit, double quantity, BigDecimal price) {
        this.unit = unit;
        this.quantity = quantity;
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

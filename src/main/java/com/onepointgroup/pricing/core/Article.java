package com.onepointgroup.pricing.core;

import java.math.BigDecimal;

public class Article {

    private final BigDecimal price;
    private final Unit unit;
    private final Currency currency;
    private Discount discount;

    public Article(BigDecimal price, Unit unit, Currency currency) {
        this.price = price;
        this.unit = unit;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Unit getUnit() {
        return unit;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public float buy(double qte){
        return buy(qte, this.unit);
    }

    public float buy(double qte, Unit unit){
        double billableQte = this.unit.convert(qte, unit);
        if (discount != null){
            DiscountPrice discountPrice = discount.apply(price, billableQte, this.unit);
            BigDecimal bill = discountPrice.getPrice()
                    .multiply(BigDecimal.valueOf(discountPrice.getQuantity()));
            return currency.round(bill);
        }
        else {
            BigDecimal bill = price.multiply(BigDecimal.valueOf(billableQte));
            return currency.round(bill);
        }
    }
}

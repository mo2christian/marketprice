package com.onepointgroup.pricing.discount;

import com.onepointgroup.pricing.core.Discount;
import com.onepointgroup.pricing.core.DiscountPrice;
import com.onepointgroup.pricing.core.Unit;

import java.math.BigDecimal;

public class PayTwoOneFreeDiscount implements Discount {
    @Override
    public DiscountPrice apply(BigDecimal price, double qte, Unit unit) {
        BigDecimal d = new BigDecimal(qte);
        if (d.doubleValue() - d.intValue() != 0){
            throw new IllegalArgumentException(("Invalid quantity"));
        }
        int discountQte = 0;
        for (int i = d.intValue(); i > 2; i = i - 2){
            discountQte++;
        }
        return new DiscountPrice(unit, d.intValue() - discountQte, price);
    }
}

package com.onepointgroup.pricing.core;

import java.math.BigDecimal;

public interface Discount {

    DiscountPrice apply(BigDecimal price, double qte, Unit unit);

}

package com.onepointgroup.pricing.currency;

import com.onepointgroup.pricing.core.Currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Euro implements Currency {

    @Override
    public float round(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP).floatValue();
    }
}

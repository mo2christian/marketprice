package com.onepointgroup.pricing.unit;

import com.onepointgroup.pricing.core.Unit;

import java.math.BigDecimal;

public enum OneUnit implements Unit {

    ONE;

    @Override
    public boolean isConvertibleTo(Unit unit) {
        return unit instanceof OneUnit;
    }

    @Override
    public double convert(double qte, Unit unit) {
        if (!this.isConvertibleTo(unit)){
            throw new IllegalArgumentException("cannot convert this unit");
        }
        BigDecimal d = new BigDecimal(qte);
        if (d.doubleValue() - d.intValue() != 0){
            throw new IllegalArgumentException(("Invalid quantity"));
        }
        return d.doubleValue();
    }
}

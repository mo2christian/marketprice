package com.onepointgroup.pricing.unit;

import com.onepointgroup.pricing.core.Unit;

public enum OunceUnit implements Unit {

    KG(1000),
    HG(100),
    DIG(10),
    G(1);

    private final double rank;

    OunceUnit(double rank){
        this.rank = rank;
    }

    @Override
    public boolean isConvertibleTo(Unit unit) {
        return unit instanceof OunceUnit;
    }

    @Override
    public double convert(double qte, Unit unit) {
        if (!this.isConvertibleTo(unit)){
            throw new IllegalArgumentException("cannot convert this unit");
        }
        OunceUnit ounceUnit = (OunceUnit)unit;
        return (qte * ounceUnit.rank) / this.rank;
    }
}

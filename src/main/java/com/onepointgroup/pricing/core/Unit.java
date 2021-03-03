package com.onepointgroup.pricing.core;

public interface Unit {

    boolean isConvertibleTo(Unit unit);

    double convert(double qte, Unit unit);

}

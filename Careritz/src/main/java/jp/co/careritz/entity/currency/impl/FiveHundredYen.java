package jp.co.careritz.entity.currency.impl;

import jp.co.careritz.entity.currency.ICurrency;

public class FiveHundredYen implements ICurrency {

    private static final Integer value = 500;

    @Override
    public Integer getValue() {
        return value;
    }
}

package jp.co.careritz.entity.currency.impl;

import jp.co.careritz.entity.currency.ICurrency;

public class OneHundredYen implements ICurrency {

    private static final Integer value = 100;

    @Override
    public Integer getValue() {
        return value;
    }
}

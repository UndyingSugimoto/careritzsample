package jp.co.careritz.entity.currency.impl;

import jp.co.careritz.entity.currency.ICurrency;

public class ThousandYen implements ICurrency {

    private static final Integer value = 1000;

    @Override
    public Integer getValue() {

        return value;
    }
}

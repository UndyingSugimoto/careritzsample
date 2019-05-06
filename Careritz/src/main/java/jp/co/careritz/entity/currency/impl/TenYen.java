package jp.co.careritz.entity.currency.impl;

import jp.co.careritz.entity.currency.ICurrency;

public class TenYen implements ICurrency {

    private static final Integer value = 10;

    @Override
    public Integer getValue() {

        return value;
    }
}

package jp.co.careritz.entity.currency.impl;

import jp.co.careritz.entity.currency.ICurrency;

public class FiftyYen implements ICurrency {

    private static final Integer value = 50;

    @Override
    public Integer getValue() {

        return value;
    }

}

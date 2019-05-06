package jp.co.careritz.service;

import jp.co.careritz.entity.currency.ICurrency;
import jp.co.careritz.entity.currency.impl.FiftyYen;
import jp.co.careritz.entity.currency.impl.FiveHundredYen;
import jp.co.careritz.entity.currency.impl.OneHundredYen;
import jp.co.careritz.entity.currency.impl.TenYen;
import jp.co.careritz.entity.currency.impl.ThousandYen;

public class CurrencyFactory {

    public static ICurrency create(final Integer val) {
        switch (val) {
            case 10:
                return new TenYen();
            case 50:
                return new FiftyYen();
            case 100:
                return new OneHundredYen();
            case 500:
                return new FiveHundredYen();
            case 1000:
                return new ThousandYen();
            default:
                throw new IllegalArgumentException("Create Currency Error.");
        }

    }
}

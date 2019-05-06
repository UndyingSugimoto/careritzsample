package jp.co.careritz.entity.currency.impl;

import java.util.ArrayList;
import java.util.List;
import jp.co.careritz.entity.currency.ICurrency;
import jp.co.careritz.entity.currency.ICurrencyMeck;

public class FifttyYenMeck implements ICurrencyMeck {

    private final Integer size = 30;
    private List<ICurrency> currencyist = new ArrayList<>();

    @Override
    public boolean add(ICurrency currency) {
        if (this.currencyist.size() == this.size) {
            return false;
        }
        this.currencyist.add(currency);

        return true;
    }

    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public Integer sum() {
        return currencyist.stream().mapToInt(t -> t.getValue()).sum();
    }

    @Override
    public boolean isEnough(Integer target) {
        return this.currencyist.stream().mapToInt(t -> t.getValue()).sum() >= target;
    }

}

package jp.co.careritz.entity.currency.impl;

import java.util.ArrayList;
import java.util.List;
import jp.co.careritz.entity.currency.ICurrency;
import jp.co.careritz.entity.currency.ICurrencyMeck;

public class TenYenMeck implements ICurrencyMeck {

    private final Integer size = 30;
    private List<ICurrency> tenYenList = new ArrayList<>();

    @Override
    public boolean add(ICurrency currency) {
        if (this.tenYenList.size() == this.size) {
            return false;
        }
        this.tenYenList.add(currency);

        return true;
    }

    @Override
    public Integer size() {
        return this.size;
    }

    @Override
    public Integer sum() {
        return tenYenList.stream().mapToInt(t -> t.getValue()).sum();
    }

    @Override
    public boolean isEnough(Integer target) {
        return this.tenYenList.stream().mapToInt(t -> t.getValue()).sum() >= target;
    }
}

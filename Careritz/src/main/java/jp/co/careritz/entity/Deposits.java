package jp.co.careritz.entity;

import jp.co.careritz.entity.currency.ICurrencyMeck;
import jp.co.careritz.entity.currency.impl.FifttyYenMeck;
import jp.co.careritz.entity.currency.impl.OneHundredYenMeck;
import jp.co.careritz.entity.currency.impl.TenYenMeck;
import jp.co.careritz.entity.currency.impl.ThousandYenMeck;

public class Deposits {

    private ICurrencyMeck thousandYenMeck = new ThousandYenMeck();
    private ICurrencyMeck fiveHundredYenMeck = new FifttyYenMeck();
    private ICurrencyMeck oneHundredYenMeck = new OneHundredYenMeck();
    private ICurrencyMeck fifttyYenMeck = new FifttyYenMeck();
    private ICurrencyMeck tenYenMeck = new TenYenMeck();

    public ICurrencyMeck getThousandYenMeck() {
        return thousandYenMeck;
    }

    public ICurrencyMeck getFiveHundredYenMeck() {
        return fiveHundredYenMeck;
    }

    public ICurrencyMeck getOneHundredYenMeck() {
        return oneHundredYenMeck;
    }

    public ICurrencyMeck getFifttyYenMeck() {
        return fifttyYenMeck;
    }

    public ICurrencyMeck getTenYenMeck() {
        return tenYenMeck;
    }

    public Integer returnCoins() {
        Integer result = 0;
        result = result + this.getThousandYenMeck().sum();
        result = result + this.getFiveHundredYenMeck().sum();
        result = result + this.getOneHundredYenMeck().sum();
        result = result + this.getFifttyYenMeck().sum();
        result = result + this.getTenYenMeck().sum();
        return result;
    }


}

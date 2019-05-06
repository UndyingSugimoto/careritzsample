package jp.co.careritz.entity.currency;

public interface ICurrencyMeck {

    public boolean add(ICurrency currency);

    public Integer size();

    public Integer sum();

    public boolean isEnough(Integer target);

}

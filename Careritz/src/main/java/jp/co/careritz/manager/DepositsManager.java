package jp.co.careritz.manager;

import jp.co.careritz.entity.currency.ICurrency;

/**
 * 入出金情報を管理する責務を持つクラスです。
 *
 * @author kouji360
 *
 */
public class DepositsManager {

    /**
     * 入金額
     */
    private Integer deposit = 0;

    /**
     * 入金処理を行います。
     *
     * @param cur 入金額
     */
    public void addDeposits(ICurrency cur) {
        // 入金処理
        deposit = deposit + cur.getValue();
    }

    /**
     * お釣りを返却します。
     */
    public void returnDeposits() {
        this.deposit = 0;
    }

    /**
     * 現在の入金額を取得します。
     *
     * @return 入金額
     */
    public Integer getDeposits() {
        return this.deposit;
    }

    /**
     * 出金処理を行います。
     *
     * @param value 出金額
     */
    public void minusDeposits(Integer value) {
        this.deposit = this.deposit - value;
    }
}

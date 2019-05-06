package jp.co.careritz.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jp.co.careritz.entity.item.IItem;
import jp.co.careritz.entity.item.impl.Coffee;
import jp.co.careritz.entity.item.impl.MikanJuce;

/**
 * 商品在庫の管理、ならびに商品の情報を管理することが責務であるクラスです。
 *
 * @author kouji360
 *
 */
public class StockManager {

    /**
     * 商品在庫の一覧
     */
    private List<IItem> itemList = new ArrayList<>();

    /**
     * コンストラクタで商品一覧をセットします。
     */
    public StockManager() {
        itemList.add(new MikanJuce());
        itemList.add(new Coffee());
    }

    /**
     * 商品の購入処理を行います。
     *
     * @param itemCode 商品コード
     * @param depositsManager 入出金管理クラス
     * @return 商品購入の是非
     */
    public boolean buyItem(String itemCode, DepositsManager depositsManager) {
        java.util.Optional<IItem> result =
                this.itemList.stream().filter(t -> (t.getItemCode().equals(itemCode))).findFirst();
        if (result.isPresent()) {
            IItem item = result.get();
            if (item.canBuy(depositsManager.getDeposits())) {
                item.buyItem();
                depositsManager.minusDeposits(item.getPrice());
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 取扱商品コードの一覧を取得します。
     *
     * @return 取扱商品コード一覧
     */
    public List<String> getItemCodes() {
        return this.itemList.stream().map(t -> t.getItemCode()).collect(Collectors.toList());
    }

    /**
     * 取扱商品の一覧を取得します。
     *
     * @return 取扱商品一覧
     */
    public List<IItem> getItems() {
        return this.itemList;
    }

    /**
     * 標準出力に取扱商品の状態をトレースします。<br>
     * 引数の入金額、在庫数に応じて商品状態をトレースします。
     *
     * @param deposits 現在の入金金額
     */
    public void printItemList(Integer deposits) {

        this.getItems().stream().forEach(t -> {
            t.toViewString(deposits);
        });
    }


}

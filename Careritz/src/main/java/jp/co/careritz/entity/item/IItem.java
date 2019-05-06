package jp.co.careritz.entity.item;

/**
 * 商品のインターフェイスです。
 *
 * @author kouji360
 *
 */
public interface IItem {

    /**
     * 商品名を取得します。
     *
     * @return 商品名
     */
    public String getName();

    /**
     * 商品の現在個数を取得します。
     *
     * @return 現在個数
     */
    public Integer getStockCount();

    /**
     * 商品が購入可能か否かを返します。<br>
     * 判定には、引数の入金額のほか、在庫数もチェックします。
     *
     * @param deposits 入金額
     * @return 購入可能か否か
     */
    public boolean canBuy(Integer deposits);

    /**
     * 商品金額に対して、引数の額が足りているかを判定します。
     *
     * @param money 入金額
     * @return 十分か否か
     */
    public boolean isEnough(Integer money);

    /**
     * 商品金額を返します。
     *
     * @return 商品金額
     */
    public Integer getPrice();

    /**
     * 現在の商品在庫状態を標準出力します。<br>
     * 引数と在庫数に応じて変化します。
     *
     * @param deposits 入金額
     */
    public void toViewString(Integer deposits);

    /**
     * 商品コードを取得します。
     *
     * @return 商品コード
     */
    public String getItemCode();

    /**
     * 購入処理を行います。
     */
    public void buyItem();

}

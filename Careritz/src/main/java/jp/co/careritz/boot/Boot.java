package jp.co.careritz.boot;

import jp.co.careritz.entity.currency.ICurrency;
import jp.co.careritz.manager.DepositsManager;
import jp.co.careritz.manager.InputManager;
import jp.co.careritz.manager.StockManager;
import jp.co.careritz.service.CurrencyFactory;

/**
 * 処理の起点となるクラスです。
 *
 * @author kouji360
 *
 */
public class Boot {

    public static void main(String[] args) {

        InputManager inputManager = new InputManager();
        DepositsManager depositsManager = new DepositsManager();
        StockManager stockManager = new StockManager();
        boolean systemValid = true;

        while (systemValid) {
            System.out.println("現在投入金額: " + depositsManager.getDeposits());

            String input = inputManager.standardInput();

            if (inputManager.isValidNumber(input)) {
                // 数値であれば、金額の投入とみなす
                ICurrency insertCoin = CurrencyFactory.create(Integer.parseInt(input));
                depositsManager.addDeposits(insertCoin);
                stockManager.printItemList(depositsManager.getDeposits());
                continue;
            }
            if (inputManager.isValidItemId(input)) {
                // 有効な商品IDであれば、商品の選択とみなす
                if (stockManager.buyItem(input, depositsManager)) {
                    System.out.println("MESSAGE :商品が購入されました");
                } else {
                    System.out.println("MESSAGE :商品の購入に失敗しました");
                }
                stockManager.printItemList(depositsManager.getDeposits());
                continue;
            }
            if (inputManager.isReturnDepositsMode(input)) {
                // 特殊文字であれば、お釣りの返却とみなす
                depositsManager.returnDeposits();
                System.out.println("MESSAGE :お釣りを返却しました");
                stockManager.printItemList(depositsManager.getDeposits());
                continue;
            }
            if (inputManager.isManagedMode(input)) {
                // 特殊文字列であれば、管理モードとみなす
                // TODO not impl yet.
            }

            System.out.println("MESSAGE :有効な値を入力してください。");
        }
    }

}



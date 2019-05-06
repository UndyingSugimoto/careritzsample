package jp.co.careritz.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 標準入力の制御、並びに入力値のバリデーションを行う責務をもつクラスです。
 *
 * @author kouji360
 *
 */
public class InputManager {


    /**
     * 標準入力待受にし、標準入力値を受け取ります。
     *
     * @return 入力された値
     */
    public String standardInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("コインを投入、もしくは商品IDを入力してください。");
        try {
            return new String(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 入力値が有効な数値であるかどうかをチェックします。<br>
     * 有効な入力値 10,50,100,500,1000
     *
     * @param param 入力値
     * @return 有効か否か
     */
    public boolean isValidNumber(String param) {
        switch (param) {
            case "1000":
            case "500":
            case "100":
            case "50":
            case "10":
                return true;
            default:
                return false;
        }
    }

    /**
     * 入力値が有効な商品コードであるかどうかをチェックします。
     *
     * @param param 入力値
     * @return 有効か否か
     */
    public boolean isValidItemId(String param) {
        StockManager stockManager = new StockManager();
        return stockManager.getItemCodes().stream().filter(t -> param.equals(t)).findFirst()
                .isPresent();
    }

    /**
     * 入力値が管理モードであるかどうかをチェックします。<br>
     * 管理モードである場合は、文字列「ADMIN」です。
     *
     * @param param 入力値
     * @return 有効か否か
     */
    public boolean isManagedMode(String param) {
        return param.equals("ADMIN");
    }

    /**
     * 入力値がお釣り返却モードであるかどうかをチェックします。<br>
     * お釣り返却モードである場合は、文字列「RETURN」です。
     *
     * @param param 入力値
     * @return 有効か否か
     */
    public boolean isReturnDepositsMode(String param) {
        return param.equals("RETURN");
    }

}

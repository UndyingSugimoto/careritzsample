package jp.co.careritz.entity.item;

/**
 * 商品のベースとなる抽象クラスです。
 *
 * @author kouji360
 *
 */
public class BaseItem implements IItem {

    protected String name = "base";
    protected Integer price = 0;
    protected Integer size = 0;
    protected String ItemCode = "";
    protected Integer stockÇount;

    public BaseItem(String name, String itemCode, Integer price, Integer size, Integer stockCount) {
        this.name = name;
        this.ItemCode = itemCode;
        this.price = price;
        this.size = size;
        this.stockÇount = stockCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getStockCount() {
        return this.stockÇount;
    }

    @Override
    public boolean canBuy(Integer deposits) {
        return deposits >= this.price && stockÇount > 0;
    }

    @Override
    public boolean isEnough(Integer money) {
        return money >= this.price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public void toViewString(Integer deposits) {
        System.out.println("  -----------");
        System.out.println("  |         |");
        System.out.println("  |         |");
        System.out.println("  |         |");
        System.out.println("  |         |");
        System.out.println("  |         |");
        System.out.println("  |         |");
        System.out.println("  -----------");
        System.out.println("  " + this.name);
        System.out.println("  商品コード: " + this.ItemCode);
        System.out.println("  在庫数: " + this.stockÇount);
        System.out.println(this.canBuy(deposits) ? "  購入可" : "  購入不可");
    }

    @Override
    public String getItemCode() {
        return this.ItemCode;
    }

    @Override
    public void buyItem() {
        this.stockÇount = this.stockÇount - 1;
    }

}

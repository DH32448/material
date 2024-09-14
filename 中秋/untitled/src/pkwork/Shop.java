package pkwork;

public class Shop {//商店
    private String name;  //店铺名称
    private Good[] goods;  //武器及药

    public Shop(String name, Good[] goods) {
        this.name = name;
        this.goods = goods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Good[] getGoods() {
        return goods;
    }

    public void setGoods(Good[] goods) {
        this.goods = goods;
    }
}
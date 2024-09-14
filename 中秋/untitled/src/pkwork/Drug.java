package pkwork;

public class Drug extends Good {//商品-药
    private int hp;  //药的生命力， 一旦买了就增加玩家的生命力

    public Drug(String name, double price, int hp) {
        super(name, price);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
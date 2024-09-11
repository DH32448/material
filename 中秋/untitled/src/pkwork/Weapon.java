package pkwork;

public class Weapon extends Good{//商品-武器
    private int kill;  //武器的攻击力， 等同于玩家的攻击力

    public Weapon(int kill) {
        this.kill = kill;
    }

    public Weapon(String name, double price, int kill) {
        super(name, price);
        this.kill = kill;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }
}

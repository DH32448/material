package pkwork;

public class Player implements Pk{//玩家
    private String nickname;  //姓名
    private Weapon weapon;    //武器， 玩家的攻击力在武器中
    private int hp;           //生命力
    private double money;     //财富

    public Player() {}

    public Player(String nickname, Weapon weapon, int hp, double money) {
        this.nickname = nickname;
        this.weapon = weapon;
        this.hp = hp;
        this.money = money;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    //单次 PK 过程， 允许输出信息， 但不允许做键盘输入及循环
    @Override
    public boolean fight(Pk p) {
        Player player = (Player) p;
        if (player.hp <= 0){
            return false;
        }
        return true;
    }

    //到商店买药或武器
    //允许在这里键盘输入， 及信息输出
    //提高题：  买药时和买武器时， 如何避免使用向下转型， 多态目的就是消除 if
    @Override
    public void buy(Shop shop) {

    }
    @Override
    public String getName() {
        return this.nickname;
    }

    @Override
    public void getPlayer() {

    }

    @Override
    public void initNpc(int level) {
    }
}

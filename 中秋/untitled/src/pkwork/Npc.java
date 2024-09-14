package pkwork;

public class Npc implements Pk {//怪物
    private String kind;
    private int attack;  //攻击力
    private int hp;
    private double money;

    public Npc() {
    }

    public Npc(String kind, int attack, int hp, double money) {
        this.kind = kind;
        this.attack = attack;
        this.hp = hp;
        this.money = money;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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

    @Override
    public String toString() {
        return "Npc{" +
                "kind='" + kind + '\'' +
                ", attack=" + attack +
                ", hp=" + hp +
                ", money=" + money +
                '}';
    }

    @Override
    public String getName() {
        return this.kind;
    }

    @Override
    public void getPlayer() {

    }

    @Override
    public void initNpc(int level) {
        new Npc("二郎显圣真君", 5, 100, 4000);
    }

    //单次 PK 过程， 允许 PK 输出信息， 但不允许做键盘输入及循环
    @Override
    public boolean fight(Pk p) {
        if (p instanceof Player) {
            Player player = (Player) p;
            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " 已经被击败！");
                return false;
            }
            System.out.println(this.kind + " 攻击 " + player.getName() + "，造成 " + this.attack + " 点伤害！");
            player.setHp(player.getHp() - this.attack);
            if (player.getHp() <= 0) {
                System.out.println(player.getName() + " 已经被击败！");
                return false;
            }
        } else if (p instanceof Npc) {
            Npc npc = (Npc) p;
            if (npc.getHp() <= 0) {
                System.out.println(npc.getName() + " 已经被击败！");
                return false;
            }
        }
        return true;
    }

    @Override
    public void buy(Shop shop) {

    }
}
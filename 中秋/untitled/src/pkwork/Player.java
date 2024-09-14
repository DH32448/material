package pkwork;

public class Player implements Pk {//玩家
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
        if (p instanceof Npc) {
            Npc npc = (Npc) p;
            if (npc.getHp() <= 0) {
                System.out.println(npc.getName() + " 已经被击败！");
                return false;
            }
            System.out.println(this.nickname + " 攻击 " + npc.getName() + "，造成 " + this.weapon.getKill() + " 点伤害！");
            npc.setHp(npc.getHp() - this.weapon.getKill());
            if (npc.getHp() <= 0) {
                System.out.println(npc.getName() + " 已经被击败！");
                return false;
            }
        } else if (p instanceof Player) {
            Player player = (Player) p;
            if (player.hp <= 0) {
                System.out.println(player.getName() + " 已经被击败！");
                return false;
            }
        }
        return true;
    }

    //到商店买药或武器
    //允许在这里键盘输入， 及信息输出
    //提高题：  买药时和买武器时， 如何避免使用向下转型， 多态目的就是消除 if
    @Override
    public void buy(Shop shop) {
        System.out.println("欢迎来到商店！");
        System.out.println("1. 购买武器");
        System.out.println("2. 购买药品");
        int choice = Tool.getInt("请选择要购买的物品：");

        if (choice == 1) {
            // 购买武器的逻辑
            System.out.println("当前武器：" + this.weapon.getName() + "，攻击力：" + this.weapon.getKill());
            System.out.println("商店中的武器：");
            for (int i = 0; i < shop.getGoods().length; i++) {
                if (shop.getGoods()[i] instanceof Weapon) {
                    Weapon weapon = (Weapon) shop.getGoods()[i];
                    System.out.println((i + 1) + ". " + weapon.getName() + "，攻击力：" + weapon.getKill() + "，价格：" + weapon.getPrice());
                }
            }
            int weaponChoice = Tool.getInt("请选择要购买的武器编号：");
            if (weaponChoice > 0 && weaponChoice <= shop.getGoods().length) {
                Weapon selectedWeapon = (Weapon) shop.getGoods()[weaponChoice - 1];
                if (this.money >= selectedWeapon.getPrice()) {
                    this.money -= selectedWeapon.getPrice();
                    this.weapon = selectedWeapon;
                    System.out.println("购买成功！当前武器：" + this.weapon.getName() + "，攻击力：" + this.weapon.getKill());
                } else {
                    System.out.println("金币不足，无法购买！");
                }
            } else {
                System.out.println("无效的选择！");
            }
        } else if (choice == 2) {
            // 购买药品的逻辑
            System.out.println("当前生命值：" + this.hp);
            System.out.println("商店中的药品：");
            for (int i = 0; i < shop.getGoods().length; i++) {
                if (shop.getGoods()[i] instanceof Drug) {
                    Drug drug = (Drug) shop.getGoods()[i];
                    System.out.println((i + 1) + ". " + drug.getName() + "，恢复生命值：" + drug.getHp() + "，价格：" + drug.getPrice());
                }
            }
            int drugChoice = Tool.getInt("请选择要购买的药品编号：");
            if (drugChoice > 0 && drugChoice <= shop.getGoods().length) {
                Good selectedGood = shop.getGoods()[drugChoice - 1];
                if (selectedGood instanceof Drug) {
                    Drug selectedDrug = (Drug) selectedGood;
                    if (this.money >= selectedDrug.getPrice()) {
                        this.money -= selectedDrug.getPrice();
                        this.hp += selectedDrug.getHp();
                        System.out.println("购买成功！当前生命值：" + this.hp);
                    } else {
                        System.out.println("金币不足，无法购买！");
                    }
                } else {
                    System.out.println("无效的选择！");
                }
            } else {
                System.out.println("无效的选择！");
            }
        } else {
            System.out.println("无效的选择！");
        }
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

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", weapon=" + weapon.getName() +
                ", hp=" + hp +
                ", money=" + money +
                '}';
    }
}
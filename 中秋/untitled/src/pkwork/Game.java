package pkwork;

public class Game {//游戏管理类
    private Shop shop;   //店铺
    private Player player;  //玩家
    private Npc npc;       //怪物， 可以扩展为数组， 多个怪物， 选择对战的怪物​

    public Game() {
    }

    public Game(Shop shop, Player player, Npc npc) {
        this.shop = shop;
        this.player = player;
        this.npc = npc;
    }

    //创建商店， 初始化武器和补血药
    //如果键盘输入初始化， 允许在这里输入
    public void initGoods() {
        Good[] goods = new Good[2];
        goods[0] = new Weapon("铁剑", 100, 10);
        goods[1] = new Drug("小血瓶", 50, 20);
        shop = new Shop("武器店", goods);
    }

    //初始化玩家
    //如果键盘输入初始化， 允许在这里输入
    public void initPlayer() {
        Weapon initialWeapon = new Weapon("初始武器", 0, 10); // 初始武器攻击力为10
        player = new Player("齐天大圣", initialWeapon, 100, 50);
    }

    //初始化 npc 机器人
    //如果键盘输入初始化， 允许在这里输入
    public void initNpc(int level) {
        switch (level) {
            case 1:
                npc = new Npc("二郎显圣真君", 5, 100, 4000);
                break;
            case 2:
                npc = new Npc("二郎显圣真君(天眼开)", 10, 120, 6000);
                break;
            case 3:
                npc = new Npc("二郎显圣真君(开天斧)", 15, 140, 8000);
                break;
            case 4:
                npc = new Npc("二郎显圣真君(神剑)", 20, 100000, 10000);
                break;
            default:
                npc = new Npc("二郎显圣真君", 5, 100, 4000);
                break;
        }
    }

    public Pk getPlayer() {
        npc.setHp(npc.getHp() - player.getWeapon().getKill());
        return player;
    }

    public Pk getNpc() {
        Pk pk = npc;
        pk.initNpc(1);
        pk = npc;
        return pk;
    }

    public Shop getShop() {
        return shop;
    }
}
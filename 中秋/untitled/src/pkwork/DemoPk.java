package pkwork;

public class DemoPk {
    public static void main(String[] args) {
        System.out.println("创建游戏");
        Game game = new Game();
        game.initGoods();  //初始化商店 及商品（补血药和武器)
        game.initPlayer(); //创建一个玩家
        game.initNpc(1);  //创建一个 npc,  等级 1 级简单怪物
        for(;;) {
            int ch = Tool.getInt("1.PK  2.买东西  3.玩家状态  4.选择怪物   0.退出:");
            if (ch ==0) {
                System.out.println("结束游戏");
                break;
            }
            if (ch ==1 ) {  //这段代码不能修改
                game.getPlayer().fight(game.getNpc());  //玩家攻击 npc
                game.getNpc().fight(game.getPlayer());  // npc 主动回击
            }
            if (ch==2) {   //这段代码不能修改
                game.getPlayer().buy(game.getShop());  //玩家到店铺买东西
            }
            if (ch==3) {   //这段代码不能修改
                System.out.println(game.getPlayer());  //显示玩家信息
            }
            if (ch==4) {  //创建新怪物
                int level = Tool.getInt("请选择怪物等级1~5:");
                if (level<1 || level>5) continue;
                game.initNpc(level);
            }
            System.out.println("------------------------------------------------------");
        }
    }
}

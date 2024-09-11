package pkwork;

public interface Pk {//怪物和玩家接口
    boolean fight(Pk p);
    //剩下还有 5 个左右方法， 自己添加， 由玩家和怪物重写实现
    public void buy(Shop shop);
    public String getName();
    public void getPlayer();
    public void initNpc(int level);//刷新怪物
}

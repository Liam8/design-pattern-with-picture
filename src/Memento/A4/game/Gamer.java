package game;
import java.util.*;

public class Gamer {
    private int money;                          // 所持金钱
    private List fruits = new ArrayList();      // 获得的水果
    private Random random = new Random();       // 随机数生成器
    private static String[] fruitsname = {      // 表示水果种类的数组
        "苹果", "葡萄", "香蕉", "橘子",
    };
    public Gamer(int money) {                   // 构造函数
        this.money = money;
    }
    public int getMoney() {                     // 获取当前所持金钱
        return money;
    }
    public void bet() {                         // 投掷骰子进行游戏
        int dice = random.nextInt(6) + 1;           // 掷骰子
        if (dice == 1) {                            // 骰子结果为1…增加所持金钱
            money += 100;
            System.out.println("所持金钱增加了。");
        } else if (dice == 2) {                     // 骰子结果为2…所持金钱减半
            money /= 2;
            System.out.println("所持金钱减半了。");
        } else if (dice == 6) {                     // 骰子结果为6…获得水果
            String f = getFruit();
            System.out.println("获得了水果(" + f + ")。");
            fruits.add(f);
        } else {                                    // 骰子结果为3、4、5则什么都不会发生
            System.out.println("什么都没有发生。");
        }
    }
    public Memento createMemento() {                // 拍摄快照
        Memento m = new Memento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("好吃的")) {         // 只保存好吃的水果
                m.addFruit(f);
            }
        }
        return m;
    }
    public void restoreMemento(Memento memento) {   // 撤销
        this.money = memento.money;
        this.fruits = memento.getFruits();
    }
    public String toString() {                      // 用字符串表示主人公状态
        return "[money = " + money + ", fruits = " + fruits + "]";
    }
    private String getFruit() {                     // 获得一个水果
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "好吃的";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}

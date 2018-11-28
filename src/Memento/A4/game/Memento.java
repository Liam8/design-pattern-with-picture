package game;
import java.io.*;
import java.util.*;

public class Memento implements Serializable {  
    int money;                              // 所持金钱
    ArrayList fruits;                       // 获得的水果
    public int getMoney() {                 // 获取现在所持金钱(narrow interface)
        return money;
    }
    Memento(int money) {                    // 构造函数(wide interface)
        this.money = money;
        this.fruits = new ArrayList();
    }
    void addFruit(String fruit) {          // 赢得水果(wide interface)
        fruits.add(fruit);
    }
    List getFruits() {                     // 获取水果(wide interface)
         return (List)fruits.clone();
    }
}

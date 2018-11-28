public class StringDisplay extends AbstractDisplay {    // StringDisplay也是AbstractDisplay的子类 
    private String string;                              // 需要显示的字符串
    private int width;                                  // 以字节为单位计算出的字符串长度
    public StringDisplay(String string) {               // 构造函数中接收的字符串被
        this.string = string;                           // 保存在字段中
        this.width = string.getBytes().length;          // 同时将字符串的字节长度也保存在字段中，以供后面使用 
    }
    public void open() {                                // 重写的open方法
        printLine();                                    // 调用该类的printLine方法画线
    }
    public void print() {                               // print方法
        System.out.println("|" + string + "|");         // 给保存在字段中的字符串前后分别加上"|"并显示出来 
    }
    public void close() {                               // close方法
        printLine();                                    // 与open方法一样，调用printLine方法画线
    }
    private void printLine() {                          // 被open和close方法调用。由于可见性是private，因此只能在本类中被调用 
        System.out.print("+");                          // 显示表示方框的角的"+"
        for (int i = 0; i < width; i++) {               // 显示width个"-"
            System.out.print("-");                      // 组成方框的边框
        }
        System.out.println("+");                        // /显示表示方框的角的"+"
    }
}

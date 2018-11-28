public class CharDisplay extends AbstractDisplay {  // CharDisplay是AbstractDisplay的子类 
    private char ch;                                // 需要显示的字符
    public CharDisplay(char ch) {                   // 构造函数中接收的字符被
        this.ch = ch;                               // 保存在字段中
    }
    public void open() {                            // 在父类中是抽象方法，此处重写该方法  
        System.out.print("<<");                     // 显示开始字符"<<"
    }
    public void print() {                           // 同样地重写print方法。该方法会在display中被重复调用
        System.out.print(ch);                       // 显示保存在字段ch中的字符
    }
    public void close() {                           // 同样地重写close方法
        System.out.println(">>");                   // 显示结束字符">>"
    }
}

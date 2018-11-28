public class UpDownBorder extends Border {
    private char borderChar;                         // 表示装饰边框的字符 
    public UpDownBorder(Display display, char ch) {  // 通过构造函数指定Display和装饰边框字符
        super(display);
        this.borderChar = ch;
    }
    public int getColumns() {                        // 列数与要显示的内容的字符数相同 
        return display.getColumns();
    }
    public int getRows() {                           // 行数是内容的行数加上上下边框
        return 1 + display.getRows() + 1;
    }
    public String getRowText(int row) {              // 获取指定行的内容
        if (row == 0 || row == getRows() - 1) {
            return makeLine(borderChar, getColumns());
        } else {
            return display.getRowText(row - 1);
        }
    }
    private String makeLine(char ch, int count) {    // 生成一个由count个字符ch连续组成的字符串 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }
}

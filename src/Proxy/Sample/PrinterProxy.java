public class PrinterProxy implements Printable {
    private String name;            // 名字
    private Printer real;           // “本人”
    public PrinterProxy() {
    }
    public PrinterProxy(String name) {      // 构造函数
        this.name = name;
    }
    public synchronized void setPrinterName(String name) {  // 设置名字
        if (real != null) {
            real.setPrinterName(name);  // 同时设置“本人”的名字
        }
        this.name = name;
    }
    public String getPrinterName() {    // 获取名字
        return name;
    }
    public void print(String string) {  // 显示
        realize();
        real.print(string);
    }
    private synchronized void realize() {   // 生成“本人”
        if (real == null) {
            real = new Printer(name);
        }
    }
}

public class IncrementalNumberGenerator extends NumberGenerator {
    private int number;                     // 当前数值
    private int end;                        // 结束数值(不包含该值)
    private int inc;                        // 递增步长
    public IncrementalNumberGenerator(int start, int end, int inc) {
        this.number = start;
        this.end = end;
        this.inc = inc;
    }
    public int getNumber() {                // 获取当前数值
        return number;
    }
    public void execute() {
        while (number < end) {
            notifyObservers();
            number += inc;
        }
    }
}

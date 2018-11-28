public class TextBuilder extends Builder {
    private String buffer = "";                                 // 文档内容保存在该字段中
    public void makeTitle(String title) {                       // 纯文本的标题
        buffer += "==============================\n";               // 装饰线
        buffer += "『" + title + "』\n";                            // 为标题加上『』
        buffer += "\n";                                             // 换行
    }
    public void makeString(String str) {                        // 纯文本的字符串
        buffer += '■' + str + "\n";                                // 为字符串添加■
        buffer += "\n";                                             // 换行
    }
    public void makeItems(String[] items) {                     // 纯文本的条目
        for (int i = 0; i < items.length; i++) {
            buffer += "　・" + items[i] + "\n";                     // 为条目添加・
        }
        buffer += "\n";                                             // 换行
    }
    public void close() {                                       // 完成文档
        buffer += "==============================\n";               // 装饰线
    }
    public String getResult() {                                 // 完成后的文档
        return buffer;
    }
}

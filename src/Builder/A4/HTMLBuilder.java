import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename;                                                        // 文件名
    private PrintWriter writer;                                                     // 用于编写文件的PrintWriter
    public void makeTitle(String title) {                                           // HTML文件的标题
        filename = title + ".html";                                                 // 将标题作为文件名
        try {
            writer = new PrintWriter(new FileWriter(filename));                     // 生成 PrintWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");    // 输出标题
        writer.println("<h1>" + title + "</h1>");
    }
    public void makeString(String str) {                                            // HTML文件中的字符串
        writer.println("<p>" + str + "</p>");                                       // 用<p>标签输出
    }
    public void makeItems(String[] items) {                                         // HTML文件中的条目
        writer.println("<ul>");                                                     // 用<ul>和<li>输出
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }
    public void close() {                                                           // 完成文档
        writer.println("</body></html>");                                           // 关闭标签
        writer.close();                                                             // 关闭文件
    }
    public String getResult() {                                                     // 编写完成的文档
        return filename;                                                            // 返回文件名
    }
}

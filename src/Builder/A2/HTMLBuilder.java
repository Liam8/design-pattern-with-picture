import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename;                                    // 文件名
    private PrintWriter writer;                                 // 用于编写文件的PrintWriter
    protected void buildTitle(String title) {                       // HTML文件的标题
        filename = title + ".html";                                 // 将标题作为文件名
        try {
            writer = new PrintWriter(new FileWriter(filename));     // 生成PrintWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title></head><body>");    // 输出标题  
        writer.println("<h1>" + title + "</h1>");
    }
    protected void buildString(String str) {                        // HTML中的文字
        writer.println("<p>" + str + "</p>");                       // 输出<p>标签
    }
    protected void buildItems(String[] items) {                     // HTML中的条目
        writer.println("<ul>");                                     // 输出<ul>和<li>
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }
    protected void buildDone() {                                 // 完成文档
        writer.println("</body></html>");                           // 关闭标签
        writer.close();                                             // 关闭文件
    }
    public String getResult() {
        return filename;                                            // 返回文件名
    }
}

import java.util.ArrayList;
import java.util.Iterator;

class ElementArrayList extends ArrayList implements Element {
    public void accept(Visitor v) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Element e = (Element)it.next();
            e.accept(v);
        }
    }
}

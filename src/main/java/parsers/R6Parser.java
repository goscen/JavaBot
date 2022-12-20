package parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import parsers.IParser;

import java.io.IOException;

public class R6Parser implements IParser {

    private Document doc;
    String name;
    public Boolean bFlag = Boolean.FALSE;

    @Override
    public void getDocument() {
        try {

            doc = Jsoup.connect("https://r6.tracker.network/profile/pc/" + name).get();

        } catch (IOException e) {
            bFlag = Boolean.TRUE;

        }
    }

    @Override
    public String getStat(String dataName) {
        Elements tagInf = doc.select("div[data-stat=" + dataName + "]");
        return tagInf.html().split("\n")[0];
    }

    public R6Parser(String name) {
        this.name = name;
    }
}

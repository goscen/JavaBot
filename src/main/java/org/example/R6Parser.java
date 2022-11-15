package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class R6Parser implements IParser {

    Document doc;
    private String name;
    @Override
    public void getDocument() {
        try {
            doc = Jsoup.connect("https://r6.tracker.network/profile/pc/" + name).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getHours() {
        Elements tagInf = doc.select("div[data-stat=PVPTimePlayed]");
        return tagInf.html();
    }

    @Override
    public String getKD() {
        Elements tagInf = doc.select("div[data-stat=PVPWLRatio]");
        return tagInf.html();
    }

    @Override
    public String winPercent() {
        Elements tagInf = doc.select("div[data-stat=PVPKDRatio]");
        return tagInf.html();
    }

    @Override
    public String playedMatch() {
        Elements tagInf = doc.select("div[data-stat=PVPMatchesPlayed]");
        return tagInf.html();
    }
    R6Parser(String name){
        this.name = name;
    }
}

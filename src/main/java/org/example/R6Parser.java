package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.IOException;

public class R6Parser implements IParser {

    private Document doc;
    String name;
    Boolean bFlag = Boolean.FALSE;
    @Override
    public void getDocument() {
        try {

            doc = Jsoup.connect("https://r6.tracker.network/profile/pc/" + name).get();

        } catch (IOException e) {
            bFlag = Boolean.TRUE;

        }

    }

    @Override
    public String getHours() {
        Elements tagInf = doc.select("div[data-stat=PVPTimePlayed]");
        return tagInf.html();
    }

    @Override
    public String getKD() {
        Elements tagInf = doc.select("div[data-stat=PVPKDRatio]");
        System.out.println(tagInf.getClass().getName());
        return tagInf.html().split("\n")[0];
    }

    @Override
    public String winPercent() {
        Elements tagInf = doc.select("div[data-stat=PVPWLRatio]");
        return tagInf.html().split("\n")[0];
    }

    @Override
    public String playedMatch() {
        Elements tagInf = doc.select("div[data-stat=PVPMatchesPlayed]");
        return tagInf.html();
    }

    R6Parser(String name) {
        this.name = name;
    }
}

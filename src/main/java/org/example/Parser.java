package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {

    Document doc;

    {
        try {
            doc = Jsoup.connect("https://r6.tracker.network/profile/pc/Booba.BrainDead").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void getHours()

    {

        Elements listNews = doc.select("div[data-stat=PVPTimePlayed]");
        System.out.println(listNews.html());

    }
}

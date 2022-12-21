package parsers;


import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApexParser {
    String name;
    public Boolean bFlag = Boolean.FALSE;

    public void getDocument() {
        try {
            URL url = new URL("https://public-api.tracker.gg/v2/apex/standard/profile/origin/Fuhhnqq");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("TRN-Api-Key", "7e590215-1520-4166-a12a-82299a775e61");
            http.setRequestProperty("Accept", "application/json");

            StringBuilder sb = new StringBuilder();
            if (HttpURLConnection.HTTP_OK == http.getResponseCode()) {

                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }

                JSONObject jsonObj = new JSONObject(sb.toString());
                ///jsonObj - нормально выводится, осталось его спарсить
                System.out.println((JSONObject) jsonObj.get("userInfo"));

            } else {
                bFlag = Boolean.TRUE;
            }
        } catch (IOException e) {
            bFlag = Boolean.TRUE;
        }
    }


    public ApexParser(String name) {
        this.name = name;
    }
}

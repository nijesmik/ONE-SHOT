package oneshot.util.crawler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class starbucksCrawler {
    static int rs = 0;

    public static void starbucksCrawling(String menuTabCode) {
        try {
            String URL = "https://www.starbucks.co.kr/upload/json/menu/" + menuTabCode + ".js";
            Document doc = Jsoup.connect(URL).ignoreContentType(true).get();
            Elements elements = doc.select("body");
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonText = (JSONObject) jsonParser.parse(elements.text());
            JSONArray menuList = (JSONArray) jsonText.get("list");
            StringBuilder query = new StringBuilder();
            for (int i = 0; i < menuList.size(); i++) {
                JSONObject menu = (JSONObject) menuList.get(i);
                Iterator<String> iter = menu.keySet().iterator();
                String menuName = null;
                String img = null;
                while (iter.hasNext()) {
                    String key = iter.next();
                    String value = String.valueOf(menu.get(key));
                    if (key.equals("product_NM")) {
                        menuName = value;
                    } else if (key.equals("file_PATH")) {
                        img = "https://www.starbucks.co.kr" + value;
                    }
                }
                if (menuName != null && img != null) {
                    query.append(String.format("(\"1\", \"%s\", \"%s\", null, null, null, null),", menuName, img));
                }
            }
            try {
                rs += mysqlUtil.insertDB(query.substring(0, query.length() - 1) + ";");
            } catch (Exception e) {
                System.out.println("Starbucks SQL Exception : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Starbucks Crawling Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<String> menuTabCodelist = new ArrayList<>();
        menuTabCodelist.add("W0000171");
        menuTabCodelist.add("W0000060");
        menuTabCodelist.add("W0000003");
        menuTabCodelist.add("W0000004");
        menuTabCodelist.add("W0000005");
        menuTabCodelist.add("W0000422");
        menuTabCodelist.add("W0000061");
        menuTabCodelist.add("W0000075");
        menuTabCodelist.add("W0000053");
        menuTabCodelist.add("W0000062");
        for (String menuTabCode : menuTabCodelist) {
            starbucksCrawling(menuTabCode);
        }
        System.out.println("Starbucks Affected Row : " + rs);
    }
}

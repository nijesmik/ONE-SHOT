package oneshot.util.crawler;

import java.util.List;

import oneshot.model.dto.Menu;

public class mammothcoffeeMenuDetailCrawler {
    static int rs = 0;

    public static void mammothcoffeeMenuDetailCrawling(int brandId) {
        try {
            List<Menu> list = mysqlUtil.selectMenu(brandId);
            StringBuilder query = new StringBuilder();
            String[] temperature = { "ICE", "HOT" };
            for (int j = 0; j < temperature.length; j++) {
                String[] size = { "S", "M", "L" };
                String[] sizeName;
                if (temperature[j].equals("ICE")) {
                    sizeName = new String[] { "S 14oz(420ml)", "M 20oz(600ml)", "L 32oz(960ml)" };
                } else {
                    sizeName = new String[] { "S 12oz(360ml)", "M 16oz(480ml)", "L 22oz(660ml)" };
                }
                for (int i = 0; i < size.length; i++) {
                    for (Menu menu : list) {
                        query.append(String.format("(%d, %d, \"%s\", \"%s\", \"%s\"),", menu.getMenuId(),
                                3000 + 500 * i, size[i], sizeName[i], temperature[j]));
                        rs++;
                    }
                }
            }
            try {
                mysqlUtil.insertMenuDetail(query.substring(0, query.length() - 1) + ";");
            } catch (Exception e) {
                System.out.println("Mammothcoffee MenuDetail SQL Exception : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Mammothcoffee MenuDetail Crawling Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        mammothcoffeeMenuDetailCrawling(2);
        System.out.println("Mammothcoffee MenuDetail Affected Row : " + rs);
    }
}

package oneshot.util.crawler;

import java.util.List;

import oneshot.model.dto.Menu;

public class starbucksMenuDetailCrawler {
    static int rs = 0;

    public static void starbucksMenuDetailCrawling(int brandId) {
        try {
            List<Menu> list = mysqlUtil.selectMenu(brandId);
            StringBuilder query = new StringBuilder();
            String[] temperature = { "ICE", "HOT" };
            String[] size = { "S", "M", "L" };
            String[] sizeName = { "tall 355ml", "grande 473ml", "venti 591ml" };
            for (int j = 0; j < temperature.length; j++) {
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
                System.out.println("Starbucks MenuDetail SQL Exception : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Starbucks MenuDetail Crawling Exception : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        starbucksMenuDetailCrawling(1);
        System.out.println("Starbucks MenuDetail Affected Row : " + rs);
    }
}

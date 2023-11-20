package oneshot.model.service;

import java.util.List;

import oneshot.model.dto.Menu;

public interface MenuService {

    int createMenu(Menu menu);

    List<Menu> getMenuByBrandId(int BrandId);

    Menu getMenuByMenuId(int menuId);

    int updateMenu(Menu menu, int menuId);

    int deleteMenu(int menuId);

    List<String> getMenuType(int parseInt);

}
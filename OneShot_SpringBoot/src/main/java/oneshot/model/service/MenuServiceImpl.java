package oneshot.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oneshot.model.dao.MenuDao;
import oneshot.model.dao.MenuDetailDao;
import oneshot.model.dto.Menu;
import oneshot.model.dto.MenuDetail;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuDetailDao menuDetailDao;

    @Override
    public int createMenu(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public List<Menu> getMenuByBrandId(int brandId) {
        List<Menu> menuList = menuDao.selectByBrandId(brandId);
        List<MenuDetail> menuDetailList = menuDetailDao.selectBrandMenuDetail(brandId);
        Map<Integer, MenuDetail> menuDetailMap = new HashMap();
        for (MenuDetail menuDetail : menuDetailList) {
            if (menuDetail.getSize().equals("L")) {
                menuDetailMap.put(menuDetail.getMenuId(), menuDetail);
            }
        }
        for (MenuDetail menuDetail : menuDetailList) {
            if (menuDetail.getSize().equals("S")) {
                menuDetailMap.put(menuDetail.getMenuId(), menuDetail);
            }
        }
        for (MenuDetail menuDetail : menuDetailList) {
            if (menuDetail.getSize().equals("M")) {
                menuDetailMap.put(menuDetail.getMenuId(), menuDetail);
            }
        }
        for (Menu menu : menuList) {
            MenuDetail menuDetail = menuDetailMap.get(menu.getMenuId());
            menu.setDefaultPrice(menuDetail.getPrice());
            menu.setDefaultSize(menuDetail.getSize());
            menu.setDefaultSizeName(menuDetail.getSizeName());
        }
        return menuList;
    }

    @Override
    public List<String> getMenuType(int brandId) {
        return menuDao.selectMenuType(brandId);
    }

    @Override
    public Menu getMenuByMenuId(int menuId) {
        return menuDao.selectOne(menuId);
    }

    @Override
    public int updateMenu(Menu menu, int menuId) {
        Menu oldMenu = menuDao.selectOne(menuId);
        menu.update(menuId, oldMenu);
        return menuDao.update(menu);
    }

    @Override
    public int deleteMenu(int menuId) {
        return menuDao.delete(menuId);
    }

}

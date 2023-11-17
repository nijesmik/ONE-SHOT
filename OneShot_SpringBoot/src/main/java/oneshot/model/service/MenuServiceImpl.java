package oneshot.model.service;

import java.util.List;
import oneshot.model.dao.MenuDao;
import oneshot.model.dto.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public int createMenu(Menu menu) {
        return menuDao.insert(menu);
    }

    @Override
    public List<Menu> getMenuByBrandId(int brandId) {
        return menuDao.selectByBrandId(brandId);
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

package oneshot.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oneshot.model.dao.MenuDetailDao;
import oneshot.model.dto.MenuDetail;

@Service
public class MenuDetailServiceImpl implements MenuDetailService {

    @Autowired
    private MenuDetailDao menuDetailDao;

    @Override
    public int createMenuDetail(MenuDetail menuDetail) {
        return menuDetailDao.createMenuDetail(menuDetail);
    }

    @Override
    public List<MenuDetail> selectAllMenuDetail(int menuId) {
        return menuDetailDao.selectAllMenuDetail(menuId);
    }

    @Override
    public MenuDetail selectMenuDetail(int menuDetailId) {
        return menuDetailDao.selectMenuDetail(menuDetailId);
    }

    @Override
    public int updateMenuDetail(int menuDetailId, MenuDetail menuDetail) {
        menuDetail.setMenuDetailId(menuDetailId);
        return menuDetailDao.updateMenuDetail(menuDetail);
    }

    @Override
    public int deleteMenuDetail(int menuDetailId) {
        return menuDetailDao.deleteMenuDetail(menuDetailId);
    }

}

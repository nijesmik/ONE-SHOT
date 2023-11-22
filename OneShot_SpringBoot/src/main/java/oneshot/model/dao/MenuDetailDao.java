package oneshot.model.dao;

import java.util.List;

import oneshot.model.dto.MenuDetail;

public interface MenuDetailDao {

    int createMenuDetail(MenuDetail menuDetail);

    List<MenuDetail> selectAllMenuDetail(int menuId);

    MenuDetail selectMenuDetail(int menuDetailId);

    List<MenuDetail> selectBrandMenuDetail(int brandId);

    int updateMenuDetail(MenuDetail menuDetail);

    int deleteMenuDetail(int menuDetailId);

}
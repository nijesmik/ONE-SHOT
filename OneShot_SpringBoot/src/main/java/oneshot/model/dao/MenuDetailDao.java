package oneshot.model.dao;

import oneshot.model.dto.MenuDetail;

public interface MenuDetailDao {

    int createMenuDetail(MenuDetail menuDetail);

    MenuDetail selectMenuDetail(int menuDetailId);

    int updateMenuDetail(MenuDetail menuDetail);

    int deleteMenuDetail(int menuDetailId);
}
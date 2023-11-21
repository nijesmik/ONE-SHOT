package oneshot.model.service;

import java.util.List;

import oneshot.model.dto.MenuDetail;

public interface MenuDetailService {

    int createMenuDetail(MenuDetail menuDetail);

    List<MenuDetail> selectAllMenuDetail(int menuId);

    MenuDetail selectMenuDetail(int menuDetailId);

    int updateMenuDetail(int menuDetailId, MenuDetail menuDetail);

    int deleteMenuDetail(int menuDetailId);

}
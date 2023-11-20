package oneshot.model.service;

import oneshot.model.dto.MenuDetail;

public interface MenuDetailService {

    int createMenuDetail(MenuDetail menuDetail);

    MenuDetail selectMenuDetail(int menuDetailId);

    int updateMenuDetail(int menuDetailId, MenuDetail menuDetail);

    int deleteMenuDetail(int menuDetailId);
}
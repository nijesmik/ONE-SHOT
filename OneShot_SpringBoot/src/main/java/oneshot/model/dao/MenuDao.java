package oneshot.model.dao;

import java.util.List;
import oneshot.model.dto.Menu;

public interface MenuDao {
    int insert(Menu menu);

    List<Menu> selectByBrandId(int brandId);

    Menu selectOne(int menuId);

    int update(Menu menu);

    int delete(int menuId);
}
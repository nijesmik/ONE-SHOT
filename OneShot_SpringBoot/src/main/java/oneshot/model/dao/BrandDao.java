package oneshot.model.dao;

import java.util.List;
import oneshot.model.dto.Brand;

public interface BrandDao {
    int insert(Brand brand);

    List<Brand> selectAll();

    Brand selectOne(int brandId);

    int update(Brand brand);

    int delete(int brandId);
}
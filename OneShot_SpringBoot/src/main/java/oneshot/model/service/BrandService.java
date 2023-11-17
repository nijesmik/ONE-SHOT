package oneshot.model.service;

import java.util.List;
import oneshot.model.dto.Brand;

public interface BrandService {

    int createBrand(Brand brand);

    List<Brand> getBrands();

    int updateBrand(Brand brand, int brandId);

    int deleteBrand(int brandId);
}
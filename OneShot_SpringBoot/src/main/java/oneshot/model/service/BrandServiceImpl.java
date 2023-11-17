package oneshot.model.service;

import java.util.List;
import oneshot.model.dao.BrandDao;
import oneshot.model.dto.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public int createBrand(Brand brand) {
        return brandDao.insert(brand);
    }

    @Override
    public List<Brand> getBrands() {
        return brandDao.selectAll();
    }

    @Override
    public int updateBrand(Brand newBrand, int brandId) {
        newBrand.setBrandId(brandId);
        Brand oldBrand = brandDao.selectOne(brandId);
        if (newBrand.getBrandName() == null) {
            newBrand.setBrandName(oldBrand.getBrandName());
        }
        if (newBrand.getLogo() == null) {
            newBrand.setLogo(oldBrand.getLogo());
        }
        if (newBrand.getBrandUrl() == null) {
            newBrand.setBrandUrl(oldBrand.getBrandUrl());
        }
        return brandDao.update(newBrand);
    }

    @Override
    public int deleteBrand(int brandId) {
        return brandDao.delete(brandId);
    }
}

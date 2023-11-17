package oneshot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import oneshot.model.dto.Brand;
import oneshot.model.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/brand")
@Api(tags = "브랜드 컨트롤러")
public class BrandRestController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/create")
    @ApiOperation(value = "브랜드 추가")
    public ResponseEntity<Integer> createBrand(Brand brand) {
        int result = brandService.createBrand(brand);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    @ApiOperation(value = "브랜드 조회")
    public ResponseEntity<?> getBrands() {
        List<Brand> brands = brandService.getBrands();
        if (brands == null) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (brands.size() == 0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);
    }

    @PatchMapping("/update/{brand_id}")
    @ApiOperation(value = "브랜드 수정")
    public ResponseEntity<?> updateBrand(Brand brand, @PathVariable(name = "brand_id") int brandId) {
        int result = brandService.updateBrand(brand, brandId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{brand_id}")
    @ApiOperation(value = "브랜드 삭제")
    public ResponseEntity<?> deleteBrand(@PathVariable(name = "brand_id") int brandId) {
        int result = brandService.deleteBrand(brandId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

}
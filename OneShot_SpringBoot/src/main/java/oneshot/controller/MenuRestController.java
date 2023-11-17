package oneshot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import oneshot.model.dto.Menu;
import oneshot.model.service.MenuService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/menu")
@Api(tags = "메뉴 컨트롤러")
public class MenuRestController {
    @Autowired
    private MenuService menuService;

    @PostMapping("/create")
    @ApiOperation(value = "메뉴 추가")
    private ResponseEntity<?> createMenu(Menu menu) {
        int result = menuService.createMenu(menu);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    @ApiOperation(value = "브랜드 메뉴 조회")
    private ResponseEntity<?> getMenuByBrandId(@RequestParam String brandId) {
        List<Menu> menus = null;
        try {
            menus = menuService.getMenuByBrandId(Integer.parseInt(brandId));
        } catch (NumberFormatException e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        if (menus == null) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (menus.size() == 0) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Menu>>(menus, HttpStatus.OK);
    }

    @GetMapping("/{menu_id}")
    @ApiOperation(value = "메뉴 개별 조회")
    private ResponseEntity<?> getMenuByMenuId(@PathVariable(name = "menu_id") int menuId) {
        Menu menu = menuService.getMenuByMenuId(menuId);
        if (menu == null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Menu>(menu, HttpStatus.OK);
    }

    @PatchMapping("/update/{menu_id}")
    @ApiOperation(value = "메뉴 수정")
    private ResponseEntity<?> updateMenu(Menu menu, @PathVariable(name = "menu_id") int menuId) {
        int result = menuService.updateMenu(menu, menuId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{menu_id}")
    @ApiOperation(value = "메뉴 삭제")
    private ResponseEntity<?> deleteMenu(@PathVariable(name = "menu_id") int menuId) {
        int result = menuService.deleteMenu(menuId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
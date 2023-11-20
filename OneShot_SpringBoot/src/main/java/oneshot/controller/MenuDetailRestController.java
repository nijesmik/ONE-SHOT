package oneshot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.MenuDetail;
import oneshot.model.service.MenuDetailService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/menu-detail")
@Api(tags = "메뉴상세 컨트롤러")
public class MenuDetailRestController {
    @Autowired
    private MenuDetailService menuDetailService;

    @PostMapping("/create")
    @ApiOperation(value = "메뉴상세 추가")
    private ResponseEntity<?> createMenuDetail(@RequestBody MenuDetail menuDetail) {
        int result = menuDetailService.createMenuDetail(menuDetail);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @GetMapping("/{menuDetailId}")
    @ApiOperation(value = "메뉴 개별 조회")
    private ResponseEntity<?> selectMenuDetail(@PathVariable int menuDetailId) {
        MenuDetail menuDetail = menuDetailService.selectMenuDetail(menuDetailId);
        if (menuDetail == null) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<MenuDetail>(menuDetail, HttpStatus.OK);
    }

    @PatchMapping("/update/{menuDetailId}")
    @ApiOperation(value = "메뉴 수정")
    private ResponseEntity<?> updateMenuDetail(@PathVariable int menuDetailId, @RequestBody MenuDetail menuDetail) {
        int result = menuDetailService.updateMenuDetail(menuDetailId, menuDetail);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{menuDetailId}")
    @ApiOperation(value = "메뉴 삭제")
    private ResponseEntity<?> deleteMenuDetail(@PathVariable int menuDetailId) {
        int result = menuDetailService.deleteMenuDetail(menuDetailId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
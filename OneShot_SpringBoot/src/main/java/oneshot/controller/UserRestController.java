package oneshot.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oneshot.model.dto.User;
import oneshot.model.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@Api(tags = "유저 컨트롤러")
public class UserRestController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "유저 로그인", notes = "유저 로그인을 세션에 저장한다")
    public ResponseEntity<?> login(@RequestBody User user, HttpSession session) {
        User tmp = userService.login(user, session);
        if (tmp == null) {
            return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<User>(tmp, HttpStatus.OK);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "유저 로그아웃", notes = "유저 로그인을 세션에서 삭제한다")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "유저 회원가입")
    public ResponseEntity<?> signup(@RequestBody User user) {
        int result = userService.signup(user);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    @ApiOperation(value = "유저 조회")
    public ResponseEntity<?> idCheck(@RequestParam String email) {
        int result = userService.idCheck(email);
        if (result == 1) {
            return new ResponseEntity<Integer>(result, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @PatchMapping("/update/{user_id}")
    @ApiOperation(value = "유저 정보 수정")
    public ResponseEntity<?> updateUser(@PathVariable(name = "user_id") int userId, @RequestBody User user) {
        int result = userService.updateUser(user, userId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{user_id}")
    @ApiOperation(value = "유저 탈퇴")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "user_id") int userId) {
        int result = userService.deleteUser(userId);
        if (result == 0) {
            return new ResponseEntity<Integer>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(result, HttpStatus.OK);
    }
}
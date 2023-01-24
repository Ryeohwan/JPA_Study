package mpti.domain.member.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mpti.common.MakeBasicResponse;
import mpti.common.response.BasicResponse;
import mpti.domain.member.dto.UserDto;
import mpti.domain.member.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mpti.domain.member.application.UserService;
import java.time.LocalDateTime;


// final
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    final MakeBasicResponse makeBasicResponse;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    // email 중복체크
    @GetMapping("/duplicate")
    public ResponseEntity<BasicResponse<String>> CheckEmailDuplicated(@PathVariable String email) {
        boolean result = userService.isEmailDuplicate(email);
        String responseMessage = result ? "DUPLICATE" : "NON-DUPLICATE";
        if(result){
            logger.debug("이메일 중복을 넣었네");
        }else{
            logger.debug("이메일 사용가능");
        }
        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, responseMessage), HttpStatus.OK);
    }

    @GetMapping ("/test")
    public ResponseEntity<BasicResponse<UserDto>> test() {
        UserDto userDto = UserDto.builder().email("sdfsdafsdaf").build();
        if(userDto == null){
            System.out.println("null!");
        }else{
            System.out.println("here is it");
        }


        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, userDto), HttpStatus.OK);
    }


    @PostMapping(value = "/join")
    @ResponseBody
    public String create(User form){
        User user1 = new User();
        user1.setEmail(form.getEmail());
        user1.setName(form.getName());
        user1.setPassword(form.getPassword());
        user1.setAge(form.getAge());
        user1.setGender(form.getGender());
        user1.setPhone(form.getPhone());
        user1.setAddress(form.getAddress());
        user1.setCreateAt(LocalDateTime.now());
        user1.setUpdateAt(LocalDateTime.now());

        return userService.join(user1);
    }

    @PostMapping("find") // 개인정보 조회
    @ResponseBody
    // 일단 로그인한 후에 다시 비밀번호를 받거나 하는 인증을 통해 개인 정보 수정에 접근이 가능할테니 따로 검증은 안하겠음.
    public ResponseEntity<BasicResponse<User>> find(String email) {
        User result = userService.findByEmail(email);
        result.setPassword("");
        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, result), HttpStatus.OK);
    }

    // are you there?
    @PostMapping("check")
    @ResponseBody
    public ResponseEntity<BasicResponse<Boolean>> check(User form) {
        String email = form.getEmail();
        String name = form.getPassword();
        if (userService.relog(email, name)) {
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, userService.relog(email, name)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, userService.relog(email, name)), HttpStatus.NOT_ACCEPTABLE);
        }
    }



}

package mpti.backend.domain.member.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mpti.backend.common.MakeBasicResponse;
import mpti.backend.common.response.BasicResponse;
import mpti.backend.domain.member.dto.UserDto;
import mpti.backend.domain.member.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mpti.backend.domain.member.application.UserService;
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
    @GetMapping("/duplicate/{email}")
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
    public User create(User form){
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

        userService.join(user1);
        return user1;
    }


}

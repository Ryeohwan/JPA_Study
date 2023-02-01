package mpti.domain.member.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mpti.common.MakeBasicResponse;
import mpti.common.response.BasicResponse;
import mpti.domain.member.api.request.UserRequest;
import mpti.domain.member.api.response.UserResponse;
import mpti.domain.member.dto.UserDto;
import mpti.domain.member.entity.Ptlog;
import mpti.domain.member.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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



    // email 중복체크
    @GetMapping("/duplicate/{email}")
    public ResponseEntity<BasicResponse<String>> CheckEmailDuplicated(@PathVariable String email) {
        boolean result = userService.isEmailDuplicate(email);
        String responseMessage = result ? "DUPLICATED" : "NON-DUPLICATE";
        if(result){
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, responseMessage), HttpStatus.NOT_ACCEPTABLE);
        }else{
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, responseMessage), HttpStatus.OK);
        }

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
    public String create(UserRequest form){
        return userService.join(form);
    }

    @PostMapping("info") // 개인정보 조회
    @ResponseBody
    public ResponseEntity<BasicResponse<UserResponse>> find(String email) {
        UserResponse result = userService.findByEmail(email);
        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, result), HttpStatus.OK);
    }

    // are you there?
    @PostMapping("check")
    @ResponseBody
    public ResponseEntity<BasicResponse<Boolean>> check(User form) {
        String email = form.getEmail();
        String name = form.getName();
        if (userService.relog(email, name)) {
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, userService.relog(email, name)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, userService.relog(email, name)), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("delete")
    @ResponseBody
    public ResponseEntity<BasicResponse<String>> delete(User form) {
        String email = form.getEmail();
        String name = form.getName();
        if(userService.delete(email,name) == "SUCCESS"){
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, name), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, name), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping ("update")
    @ResponseBody
    public ResponseEntity<BasicResponse<String>> update(UserRequest form){
        String result = userService.update(form);
        return new ResponseEntity(makeBasicResponse.makeBasicResponse(SUCCESS, result), HttpStatus.OK);
    }

}

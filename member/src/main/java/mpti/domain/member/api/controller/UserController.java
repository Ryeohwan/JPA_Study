package mpti.domain.member.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mpti.common.MakeBasicResponse;
import mpti.domain.member.api.request.UserRequest;
import mpti.domain.member.api.response.UserResponse;
import mpti.domain.member.dto.BasicResponse;
import mpti.domain.member.dto.UserDto;
import mpti.domain.member.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import mpti.domain.member.application.UserService;
import javax.transaction.Transactional;
import java.nio.charset.Charset;


// final
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    final UserService userService;
    final MakeBasicResponse makeBasicResponse;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);


    // email 중복체크
    @GetMapping("/duplicate/{email}")
    public ResponseEntity<BasicResponse<String>> CheckNicknameDuplicated(@PathVariable String email) {
        boolean result = userService.isNicknameDuplicate(email);
        String responseMessage = result ? "DUPLICATE" : "NON-DUPLICATE";
        if(result){
            logger.debug("이메일 중복을 넣었네");
        }else{
            logger.debug("이메일 사용가능");
        }
        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, responseMessage), HttpStatus.OK);
    }

    @GetMapping ("/test")
    public ResponseEntity<BasicResponse<UserDto>>  test() {
        UserDto userDto = UserDto.builder().email("sdfsdafsdaf").build();
        if(userDto == null){
            System.out.println("null!");
        }else{
            System.out.println("here is it");
        }


        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(SUCCESS, userDto), HttpStatus.OK);
    }


//    @PostMapping("/join")
//    public BasicResponse<HttpStatus> setUser(@RequestBody UserRequest userRequest) {
//
//        User user = UserService.(UserDto.builder()
//                .email(userRequest.getEmail())
//                .age(userRequest.getAge())
//                .address(userRequest.getAddress())
//                .phone(userRequest.getPhone())
//                .gender(userRequest.getGender())
//                .name(userRequest.getName())
//                .phone(userRequest.getPhone())
//                .createAt(userRequest.getCreateAt())
//                .updateAt(userRequest.getUpdateAt())
//                .build()
//            );
//
//        return makeBasicResponse(SUCCESS, HttpStatus.CREATED);
//    }




}

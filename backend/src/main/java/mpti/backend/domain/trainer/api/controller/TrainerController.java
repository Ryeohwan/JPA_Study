package mpti.backend.domain.trainer.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mpti.backend.common.MakeBasicResponse;
import mpti.backend.domain.trainer.application.TrainerService;
import mpti.backend.common.response.BasicResponse;
import mpti.backend.domain.trainer.entity.Trainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


// final
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/trainer")
@RestController
public class TrainerController {
    @Autowired
    TrainerService trainerService;
    final MakeBasicResponse makeBasicResponse;
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    public static final Logger logger = LoggerFactory.getLogger(TrainerController.class);


    // email 중복체크
    @GetMapping("/duplicate/{email}")
    public ResponseEntity<BasicResponse<String>> CheckEmailDuplicated(@PathVariable String email) {
        boolean result = trainerService.isEmailDuplicate(email);
        String responseMessage = result ? "DUPLICATE" : "NON-DUPLICATE";
        if(result){
            logger.debug("이메일 중복을 넣었네");
        }else{
            logger.debug("이메일 사용가능");
        }
        return new ResponseEntity<>(makeBasicResponse.makeBasicResponse(FAIL, responseMessage), HttpStatus.OK);
    }

    @PostMapping(value = "/join")
    @ResponseBody
    public Trainer create(Trainer form){
        Trainer trainer1 = new Trainer();
        trainer1.setName(form.getName());
        trainer1.setEmail(form.getEmail());
        trainer1.setAddress(form.getAddress());
        trainer1.setPassword(form.getPassword());
        trainer1.setAge(form.getAge());
        trainer1.setGender(form.getGender());
        trainer1.setCreateAt(LocalDateTime.now());
        trainer1.setUpdateAt(LocalDateTime.now());
        trainer1.setPhone(form.getPhone());
        trainerService.join(trainer1);
        return trainer1;
    }


}

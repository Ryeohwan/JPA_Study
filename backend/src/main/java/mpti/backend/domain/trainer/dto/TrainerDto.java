package mpti.backend.domain.trainer.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
@RequiredArgsConstructor
public class TrainerDto {
    private Long id;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String phone;
    private String address;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;


}

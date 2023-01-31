package mpti.domain.member.application;


import lombok.RequiredArgsConstructor;
import mpti.domain.member.api.request.UserRequest;
import mpti.domain.member.api.response.UserResponse;
import mpti.domain.member.dao.PtlogRepository;
import mpti.domain.member.dao.UserRepository;
import mpti.domain.member.entity.Ptlog;
import mpti.domain.member.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    EntityManager user;
    private final UserRepository userRepository;
    private final PtlogRepository ptlogRepository;

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    @Transactional(readOnly = true)
    public boolean isEmailDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }

    public String join(UserRequest user) {
        User result = user.toEntity().builder()
                .email(user.getEmail())
                .age(user.getAge())
                .phone(user.getPhone())
                .address(user.getAddress())
                .gender(user.getGender())
                .name(user.getName())
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .password(user.getPassword())
                .build();
        Ptlog ptlog1 = new Ptlog();
        ptlog1.setUser(result);
        userRepository.save(result);
        ptlogRepository.save(ptlog1);
        return result.getName();
    }

    @Transactional(readOnly = true)
    public UserResponse findByEmail(String email){
        User user1 = userRepository.findUserByEmail(email);
        UserResponse result = new UserResponse();
        result.setEmail(user1.getEmail());
        result.setAge(user1.getAge());
        result.setName(user1.getName());
        result.setPhone(user1.getPhone());
        result.setAddress(user1.getAddress());
        result.setCreateAt(user1.getCreateAt());
        result.setUpdateAt(user1.getUpdateAt());
        result.setGender(user1.getGender());
        return result;
    }

    @Transactional(readOnly = true)
    public Boolean relog(String email, String name) {
        if(userRepository.findUserByEmailAndPassword(email,name).getEmail() == null){
            return false;
        }else{
            return true;
        }
    }

    public String delete(String email, String name){
        if(userRepository.deleteUserByEmailAndPassword(email,name) == 1){
            return SUCCESS;
        }else{
            return FAIL;
        }
    }

    public String update(UserRequest check){
        String email = check.getEmail();
        String password = check.getPassword();
        User temp = userRepository.findUserByEmailAndPassword(email,password);
        temp.setPhone(check.getPhone());
        temp.setAddress(check.getAddress());
        temp.setAge(check.getAge());
        temp.setUpdateAt(LocalDateTime.now());
        temp.setPassword(check.getPassword());
        temp.setGender(check.getGender());
        temp.setName(check.getName());
        String result = temp.getName();
        return result;
    }


}

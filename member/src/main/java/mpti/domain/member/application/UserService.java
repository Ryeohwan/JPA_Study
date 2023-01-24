package mpti.domain.member.application;


import lombok.RequiredArgsConstructor;
import mpti.domain.member.dao.UserRepository;
import mpti.domain.member.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean isEmailDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }

    public String join(User user) {
        userRepository.save(user);
        return user.getName();
    }


    public User findByEmail(String email){
        User result = userRepository.findUserByEmail(email);
        result.setPassword("");
        return result;
    }


    public Boolean relog(String email, String name) {
        if(userRepository.findUserByEmailAndPassword(email,name).getEmail() == null){
            return false;
        }else{
            return true;
        }
    }
}

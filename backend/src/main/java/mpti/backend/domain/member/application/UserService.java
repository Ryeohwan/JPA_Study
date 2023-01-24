package mpti.backend.domain.member.application;


import lombok.RequiredArgsConstructor;
import mpti.backend.domain.member.dao.UserRepository;
import mpti.backend.domain.member.entity.User;


import javax.transaction.Transactional;



@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    public boolean isEmailDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }

    public Long join(User user) {
        userRepository.save(user);
        return user.getId();
    }


}

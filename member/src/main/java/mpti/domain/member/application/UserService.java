package mpti.domain.member.application;

import lombok.RequiredArgsConstructor;
import mpti.domain.member.dao.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    public boolean isNicknameDuplicate(String email) {
        if (userRepository.existsByEmail(email)) {
            return true;
        }
        return false;
    }


}

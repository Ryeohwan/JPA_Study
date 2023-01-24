package mpti.backend.domain.member.config;

import mpti.backend.domain.member.application.UserService;
import mpti.backend.domain.member.dao.JpaUserRepository;
import mpti.backend.domain.member.dao.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class MemberConfig {
    // 이거 jparepository 아직 안배워서 쓸줄 몰라서 생긴 config 입니다.... 나중에 시간나면 리팩토링될 예정입니다...

    private final EntityManager em;

    public MemberConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }

    @Bean
    public UserRepository userRepository(){
        return new JpaUserRepository(em);
    }
}
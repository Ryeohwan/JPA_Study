package mpti.backend.domain.trainer.config;

import mpti.backend.domain.trainer.application.TrainerService;
import mpti.backend.domain.trainer.dao.JpaTrainerRepository;
import mpti.backend.domain.trainer.dao.TrainerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class TrainerConfig {
    // 이거 jparepository 아직 안배워서 쓸줄 몰라서 생긴 config 입니다.... 나중에 시간나면 리팩토링될 예정입니다...

    private final EntityManager em;

    public TrainerConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public TrainerService trainerService(){
        return new TrainerService(trainerRepository());
    }

    @Bean
    public TrainerRepository trainerRepository(){
        return new JpaTrainerRepository(em);
    }
}
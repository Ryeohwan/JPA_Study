package mpti.backend.domain.trainer.dao;


import mpti.backend.domain.trainer.entity.Trainer;

public interface TrainerRepository {
// JpaRepository 사용, user 의 ID 유형은 Long 타입을 주었다.
    boolean existsByEmail(String email);
    Trainer save(Trainer trainer);

}

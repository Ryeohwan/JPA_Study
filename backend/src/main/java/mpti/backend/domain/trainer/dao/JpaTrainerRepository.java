package mpti.backend.domain.trainer.dao;

import mpti.backend.domain.trainer.entity.Trainer;

import javax.persistence.EntityManager;

;
public class JpaTrainerRepository implements TrainerRepository {
    private final EntityManager em;

    public JpaTrainerRepository(EntityManager em) {
        this.em = em;
    }

    public Trainer save(Trainer trainer) {
        em.persist(trainer);
        return trainer;
    }

    public boolean existsByEmail(String email) {
        return false;
    }
}

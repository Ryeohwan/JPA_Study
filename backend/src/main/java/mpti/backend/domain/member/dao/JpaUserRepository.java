package mpti.backend.domain.member.dao;

import mpti.backend.domain.member.entity.User;

import javax.persistence.EntityManager;

;
public class JpaUserRepository implements UserRepository{
    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public boolean existsByEmail(String email) {
        return false;
    }
}

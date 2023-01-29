package mpti.domain.member.dao;

import mpti.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    @Override
    <S extends User> S save(S entity);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    int deleteUserByEmailAndPassword(String email, String password);

    
}


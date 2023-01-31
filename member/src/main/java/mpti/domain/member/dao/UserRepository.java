package mpti.domain.member.dao;

import mpti.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
    @Override
    <S extends User> S save(S entity);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    int deleteUserByEmailAndPassword(String email, String password);


}


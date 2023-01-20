package mpti.domain.member.dao;

import mpti.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
// JpaRepository 사용, user 의 ID 유형은 Long 타입을 주었다.
    boolean existsByEmail(String nickName);
}

package mpti.domain.member.dao;

import mpti.domain.member.entity.User;

public interface UserRepository{
// JpaRepository 사용, user 의 ID 유형은 Long 타입을 주었다.
    boolean existsByEmail(String email);
    User save(User user);

}

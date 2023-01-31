package mpti.domain.member.dao;

import mpti.domain.member.entity.Ptlog;
import mpti.domain.member.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PtlogRepository extends JpaRepository<Ptlog,Long> {

    @Override
    <S extends Ptlog> S save(S entity);

    Ptlog findPtlogByUser(User user);

    void deletePtlogByUser(User user);
}

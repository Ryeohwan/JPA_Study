package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // 영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            // 영속성 컨텍스트 통으로 완전 다 날려버려(1차 캐시)
            em.clear();
            // 얘 이후 다시 조회하면 영속성에 없어서 다시 1차 캐시로 올려

            Member member2 = em.find(Member.class, 150L);

            // 그럼 얘는 Jpa에서 관리 안해. 그래서 커밋할 때 반영 안됨
            System.out.println("======================");
            tx.commit();


        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}

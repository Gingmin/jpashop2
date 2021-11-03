package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //resources/META-INF/persistence.xml 파일의 <persistence-unit name="hello"> name 부분을 적어줘야 한다.
        //EntityManagerFactory는 애플리케이션 로딩 시점에 딱 하나만 있어야 한다.
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //Factory에서 EntityManager를 꺼내야 한다.
        //트랜잭션 단위마다 EntityManager를 만들어야 한다.
        EntityManager em = emf.createEntityManager();

        //JPA의 모든 작업은 트랜잭션 안에서 이뤄져야 한다.
        //getTransaction을 통해 트랜잭션을 얻을 수 있다.
        EntityTransaction tx = em.getTransaction();
        tx.begin(); //시작


        try {

            tx.commit(); //커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}

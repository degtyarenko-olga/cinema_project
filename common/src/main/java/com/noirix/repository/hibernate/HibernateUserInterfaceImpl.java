package com.noirix.repository.hibernate;

import com.noirix.domain.UsersHibernate;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;


@Repository
@Primary
@RequiredArgsConstructor
public class HibernateUserInterfaceImpl implements HibernateUserInterface {

    private final SessionFactory sessionFactory;

    private final EntityManagerFactory entityManagerFactory;

    @Override
    public UsersHibernate findById(Long id){
        return null;
    }

    @Override
    public Optional<UsersHibernate> findOne(Long id) {
        return Optional.of(findById(id));
    }

    @Override
    public List<UsersHibernate> findAll() {

        final String query = "select hb from UsersHibernate hb";

//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager.createQuery(query, UsersHibernate.class).getResultList();

        //final String query = "select * from carshop.users";

        try (Session session = sessionFactory.openSession()) {
            //return session.createNativeQuery(query, HibernateUser.class).getResultList(); - native query run possibility
            return session.createQuery(query, UsersHibernate.class).getResultList();
        }
    }

    @Override
    public List<UsersHibernate> findAll(int limit, int offset) {
        return null;
    }

    @Override
    public UsersHibernate create(UsersHibernate object) {
        return null;
    }

    @Override
    public UsersHibernate update(UsersHibernate object) {
        return null;
    }

    @Override
    public Long hardDelete(Long id) {
        return null;
    }

    @Override
    public Long delete(UsersHibernate object) {
//        try (Session session = sessionFactory.openSession()) {
//            session.delete(object);
//            return object.getId();
//        }
        return null;

    }

    @Override
    public List<UsersHibernate> findByLogin(String login) {
        return null;
    }
}

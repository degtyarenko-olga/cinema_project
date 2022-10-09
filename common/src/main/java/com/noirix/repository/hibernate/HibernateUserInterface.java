package com.noirix.repository.hibernate;

import com.noirix.domain.hibernate.UsersHibernate;
import com.noirix.repository.CRUDRepository;

import java.util.List;

public interface HibernateUserInterface extends CRUDRepository<Long, UsersHibernate> {

    Long delete(UsersHibernate object);

    List<UsersHibernate> findByLogin(String login);
}

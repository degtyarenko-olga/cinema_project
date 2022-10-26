package com.noirix.repository;

import com.noirix.domain.RolesHibernate;
import com.noirix.domain.SystemRoles;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesSpringDataRepository extends JpaRepository<RolesHibernate, Long> {

    @Cacheable("roles")
    @Query(value = "select r from RolesHibernate r")
    List<RolesHibernate> findAllCustom();

    RolesHibernate findRolesHibernateByRoleName(String roleName);

    List<RolesHibernate> findRolesHibernateById(Long userId);

    RolesHibernate findRolesHibernateByRoleName(SystemRoles roles);

    @Query(value = "select * from cinema.roles " +
            "inner join cinema.l_role_user " +
            "on cinema.roles.id = cinema.l_role_user.role_id " +
            "where cinema.l_role_user.user_id = :userId"
            , nativeQuery = true)
    List<RolesHibernate> findByUserId(Long userId);

}

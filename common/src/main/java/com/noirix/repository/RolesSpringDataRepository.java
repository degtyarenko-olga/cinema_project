package com.noirix.repository;

import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolesSpringDataRepository extends JpaRepository<Roles, Long> {

    @Cacheable("roles")
    @Query(value = "select r from Roles r")
    List<Roles> findAllCustom();

    Roles findRolesHibernateByRoleName(String roleName);

    List<Roles> findRolesHibernateById(Long userId);

    Roles findRolesHibernateByRoleName(SystemRoles roles);

    @Query(value = "select * from cinema.roles " +
            "inner join cinema.l_role_user " +
            "on cinema.roles.id = cinema.l_role_user.role_id " +
            "where cinema.l_role_user.user_id = :userId"
            , nativeQuery = true)
    List<Roles> findByUserId(Long userId);

}

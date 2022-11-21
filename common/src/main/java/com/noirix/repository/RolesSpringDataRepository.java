package com.noirix.repository;

import com.noirix.entity.Roles;
import com.noirix.entity.SystemRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesSpringDataRepository extends JpaRepository<Roles, Long> {

    Optional<Roles> findById(Long aLong);

    Optional<Roles> findRolesByRoleName(SystemRoles roles);

    @Query(value = "select * from cinema.roles " +
            "inner join cinema.l_role_user " +
            "on cinema.roles.id = cinema.l_role_user.role_id " +
            "where cinema.l_role_user.user_id = :userId"
            , nativeQuery = true)
    List<Roles> findByUserId(Long userId);

}

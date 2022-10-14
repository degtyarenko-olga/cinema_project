package com.noirix.repository.springdata;

import com.noirix.domain.UsersHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserSpringDataRepository extends JpaRepository<UsersHibernate, Long> {
   // List<UsersHibernate> findUsersHibernateByCredentials_Login(String login);

   // List<UsersHibernate> findByUserLoginAndUserNameAndBirth(String login, String name, Timestamp birthDate);

   // List<UsersHibernate> findByUserLoginAndUserNameOrBirthOrderByIdDescUserNameDesc(String login, String name, Timestamp birthDate);

    //select * from m_users where (login = ? and name = ?) or birth_date = ?

    @Query(value = "select u from UsersHibernate u")
    List<UsersHibernate> findByHQLQuery();

    Optional<UsersHibernate> findUsersHibernateByCredentials_Login(String username);



//
//    @Query(value = "select * from cinema.users", nativeQuery = true)
//    List<UsersHibernate> findByHQLQueryNative();
//
//    @Query("select u.id, u.login from UsersHibernate u")
//    List<Object[]> getPartsOfUser();
//
//    @Modifying
//    @Query(value = "insert into cinema.l_role_user(user_id, role_id) values (:user_id, :role_id)", nativeQuery = true)
//    int createRoleRow(@Param("user_id") Long userId, @Param("role_id") Long roleId);
}

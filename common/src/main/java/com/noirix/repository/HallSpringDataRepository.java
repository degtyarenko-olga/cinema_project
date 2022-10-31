package com.noirix.repository;

import com.noirix.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallSpringDataRepository extends JpaRepository<Hall, Long> {

    Hall findHallHibernateByNameHall(String name);

}

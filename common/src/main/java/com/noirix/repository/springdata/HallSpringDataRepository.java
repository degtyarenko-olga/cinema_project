package com.noirix.repository.springdata;

import com.noirix.domain.hibernate.HallHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HallSpringDataRepository extends JpaRepository<HallHibernate, Long> {

    @Query(value = "select h from HallHibernate h")
    List<HallHibernate> findAllHall();
}

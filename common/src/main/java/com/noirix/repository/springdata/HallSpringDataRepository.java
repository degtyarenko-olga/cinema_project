package com.noirix.repository.springdata;

import com.noirix.domain.HallHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HallSpringDataRepository extends JpaRepository<HallHibernate, Long> {

    @Query(value = "select h from HallHibernate h")
    List<HallHibernate> findAllHall();
}

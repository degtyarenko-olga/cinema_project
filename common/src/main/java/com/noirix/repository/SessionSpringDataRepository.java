package com.noirix.repository;

import com.noirix.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionSpringDataRepository extends JpaRepository<Session, Long> {

}

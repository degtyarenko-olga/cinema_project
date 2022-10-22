package com.noirix.repository;

import com.noirix.domain.MovieHibernate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpringDataRepository extends JpaRepository<MovieHibernate, Long> {


//    @Query(value = "select m from MovieHibernate m")
//    List<MovieHibernate> findAllMovie();

    List<MovieHibernate> findAll();

    List<MovieHibernate> findMovieHibernatesByTitle(String title);

    @Query(value = "select m from MovieHibernate m where m.genre = ?",nativeQuery = true)
    List<MovieHibernate> findAllByGenre(String genre);

}

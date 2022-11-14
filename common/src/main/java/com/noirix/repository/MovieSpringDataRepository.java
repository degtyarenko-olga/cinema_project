package com.noirix.repository;

import com.noirix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieSpringDataRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMovieByTitle(String title);

    List<Movie> findMovieByGenre(String genre);

}

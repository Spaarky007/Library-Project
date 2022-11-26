package com.newLibraryProjectt.LibraryProject.repository;

import com.newLibraryProjectt.LibraryProject.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}

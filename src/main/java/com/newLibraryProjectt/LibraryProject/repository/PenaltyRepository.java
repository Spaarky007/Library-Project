package com.newLibraryProjectt.LibraryProject.repository;

import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {

}

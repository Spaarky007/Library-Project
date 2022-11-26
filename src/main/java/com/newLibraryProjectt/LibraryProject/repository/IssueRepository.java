package com.newLibraryProjectt.LibraryProject.repository;

import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {


}

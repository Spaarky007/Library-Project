package com.newLibraryProjectt.LibraryProject.repository;

import com.newLibraryProjectt.LibraryProject.dto.BookDto;
import com.newLibraryProjectt.LibraryProject.entity.Author;
import com.newLibraryProjectt.LibraryProject.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("update Book set noOfCopies = noOfCopies-1 where id in ?1")
    void reduceStock(List<Long> availableBookId);

    @Modifying
    @Transactional
    @Query("update Book set noOfCopies = noOfCopies+1 where id in ?1")
    void addStock(List<Long> bookIdList);

    @Query(value = "select * from book where name like %?2% and tags like %?3% and language like %?4% and author_id " +
            "in (select id from author where name like %?1%)", nativeQuery = true)
    List<Book> searchBook(String authorName, String bookName, String tags, String language);
}

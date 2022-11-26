package com.newLibraryProjectt.LibraryProject.service;

import com.newLibraryProjectt.LibraryProject.Ecxeption.LibraryException;
import com.newLibraryProjectt.LibraryProject.dto.IssueDto;
import com.newLibraryProjectt.LibraryProject.dto.ReturnDto;
import com.newLibraryProjectt.LibraryProject.entity.Book;
import com.newLibraryProjectt.LibraryProject.entity.Issue;
import com.newLibraryProjectt.LibraryProject.entity.User;
import com.newLibraryProjectt.LibraryProject.external.ErrorCodes;
import com.newLibraryProjectt.LibraryProject.external.IssueType;
import com.newLibraryProjectt.LibraryProject.repository.AuthorRepository;
import com.newLibraryProjectt.LibraryProject.repository.BookRepository;
import com.newLibraryProjectt.LibraryProject.repository.IssueRepository;
import com.newLibraryProjectt.LibraryProject.repository.UserRepository;
import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    IssueRepository issueRepository;

    public String createIssue(IssueDto issueDto )throws LibraryException, Exception {
        Long userId = issueDto.getUserID();
        List<Long> bookId = issueDto.getBookId();
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent())
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.USER_NOT_FOUND);
        List<Book> bookList = bookRepository.findAllById(bookId);
        List<Book> availableBooks = bookList.stream().filter(b->b.getNoOfCopies()>0).collect(Collectors.toList());
        Date today = new Date();
        Long lTime = today.getTime()+10*24*60*60*1000;
        Date today10 = new Date(lTime);
        if(availableBooks.size() != issueDto.getBookId().size())
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.BOOK_NOT_FOUND);
        List<Long> availableBookId = bookList.stream().map(b->b.getId()).collect(Collectors.toList());
        issueRepository.save(Issue.builder().book(availableBookId).user(user.get()).issueDate(new Date())
                .expectedReturnDate(today10).issueType(IssueType.ISSUED).build());
        bookRepository.reduceStock(availableBookId);
        return "success";
    }
    public String returnIssue(ReturnDto returnDto) throws LibraryException, Exception{
        Optional<Issue> issue = issueRepository.findById(returnDto.getIssueId());
        if(!issue.isPresent())
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.ISSUE_NOT_FOUND);
        if(issue.get().getIssueType() != IssueType.ISSUED)
            throw  LibraryException.libraryExceptionIMPL(ErrorCodes.INVALID_PAGE_REQUEST);
        Issue issue1 = issue.get();
        issue1.setReturnDate(new Date());
        issue1.setIssueType(IssueType.RETURNED);
        List<Long> bookIdList = issue1.getBook();
        bookRepository.addStock(bookIdList);
        return "Returned Successfully";
    }
}

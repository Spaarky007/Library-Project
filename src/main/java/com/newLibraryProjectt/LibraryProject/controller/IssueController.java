package com.newLibraryProjectt.LibraryProject.controller;

import com.newLibraryProjectt.LibraryProject.dto.IssueDto;
import com.newLibraryProjectt.LibraryProject.dto.ReturnDto;
import com.newLibraryProjectt.LibraryProject.repository.IssueRepository;
import com.newLibraryProjectt.LibraryProject.service.IssueService;
import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/issue")
@RestController
public class IssueController {

    @Autowired
    IssueService issueService;

    @PostMapping
    public String createIssue(@RequestBody IssueDto issueDto)throws Exception{
        return issueService.createIssue(issueDto);
    }

    @PostMapping("return")
    public String returnIssue(@RequestBody ReturnDto returnDto) throws Exception{
        return issueService.returnIssue((returnDto));
    }
}

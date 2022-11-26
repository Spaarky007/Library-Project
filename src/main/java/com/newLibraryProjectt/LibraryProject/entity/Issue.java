package com.newLibraryProjectt.LibraryProject.entity;

import com.newLibraryProjectt.LibraryProject.external.IssueType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issue_generator")
    @SequenceGenerator(name = "issue_generator", sequenceName = "issue_sequence", allocationSize = 1)
    private Long id;
    @ElementCollection
    private List<Long> book;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Date issueDate;
    private Date expectedReturnDate;
    private Date returnDate;
    @Enumerated(EnumType.STRING)
    private IssueType issueType;
}

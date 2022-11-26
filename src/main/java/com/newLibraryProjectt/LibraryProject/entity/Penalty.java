package com.newLibraryProjectt.LibraryProject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Penalty {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "penalty_generator")
    @SequenceGenerator(name = "penalty_generator", sequenceName = "penalty_sequence", allocationSize = 1)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private Long amount;
    private Boolean amountPaid;
    private Date transactionDate;
}

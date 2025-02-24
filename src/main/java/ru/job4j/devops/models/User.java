package ru.job4j.devops.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(name = "first_arg")
    private Integer firstArg;

    @Column(name = "second_arg")
    private Integer secondArg;

    @Column(name = "create_date")
    private LocalDate createDate;
}

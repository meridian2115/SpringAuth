package com.example.demoauth.models;

import javax.persistence.*;

/**
 * @author Fedor Danilov 01.11.2021
 */
@Entity
public class MenuPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EMenu name;
}

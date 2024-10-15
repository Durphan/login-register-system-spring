package com.project.loginregistersystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int idUser;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

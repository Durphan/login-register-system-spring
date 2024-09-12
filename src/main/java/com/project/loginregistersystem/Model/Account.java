package com.project.loginregistersystem.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @CreationTimestamp
    private LocalDateTime date_created;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

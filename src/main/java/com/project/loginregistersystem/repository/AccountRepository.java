package com.project.loginregistersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.loginregistersystem.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "SELECT EXISTS(SELECT 1 FROM ACCOUNT WHERE USERNAME = :username)", nativeQuery = true)
    boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT IDUSER, USERNAME, PASSWORD, DATE_CREATED FROM ACCOUNT WHERE USERNAME = :username", nativeQuery = true)
    Account findByUsername(@Param("username") String username);
}

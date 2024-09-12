package com.project.loginregistersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.loginregistersystem.Model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "CALL ADDACCOUNT(:username, :password)", nativeQuery = true)
    void saveAccount(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT LOGINACCOUNT(:username, :password)", nativeQuery = true)
    int loginAccount(@Param("username") String username, @Param("password") String password);
}

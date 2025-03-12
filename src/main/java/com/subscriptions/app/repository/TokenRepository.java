package com.subscriptions.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscriptions.app.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

}

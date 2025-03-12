package com.subscriptions.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscriptions.app.model.Subscribe;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

}

package com.subscriptions.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subscriptions.app.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}

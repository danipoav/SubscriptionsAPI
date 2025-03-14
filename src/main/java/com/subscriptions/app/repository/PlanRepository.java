package com.subscriptions.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.subscriptions.app.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByServiceId(Long serviceId);
}

package com.subscriptions.app.controller.plan;

import org.springframework.stereotype.Service;

import com.subscriptions.app.model.Plan;
import com.subscriptions.app.repository.PlanRepository;
import com.subscriptions.app.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final ServiceRepository serviceRepository;

    public Plan createPlan(CreatePlanRequest request) {
        com.subscriptions.app.model.Service service = serviceRepository.findById(request.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not founded"));

        var plan = Plan.builder()
                .service(service)
                .name(request.getName())
                .price(request.getPrice())
                .period(request.getPeriod())
                .build();

        planRepository.save(plan);

        return plan;
    }

}

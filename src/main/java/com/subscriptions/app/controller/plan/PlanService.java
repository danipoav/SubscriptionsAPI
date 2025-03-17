package com.subscriptions.app.controller.plan;

import java.util.List;

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

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public List<Plan> getPlanByService(Long serviceId) {
        return planRepository.findByServiceId(serviceId);
    }

    public Plan updatePlan(Long Id, CreatePlanRequest request) {
        Plan plan = planRepository.findById(Id).orElseThrow(() -> new RuntimeException("Plan not Founded"));
        plan.setName(request.getName());
        plan.setPrice(request.getPrice());
        plan.setPeriod(request.getPeriod());
        return plan;
    }

    public void deletePlan(Long id) {
        if (!planRepository.existsById(id)) {
            throw new RuntimeException("Plan not founded");
        }
        planRepository.deleteById(id);
    }

}

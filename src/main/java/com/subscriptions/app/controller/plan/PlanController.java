package com.subscriptions.app.controller.plan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptions.app.model.Plan;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PostMapping("/admin/create.plan")
    public ResponseEntity<Plan> createPlan(@RequestBody CreatePlanRequest request) {
        return ResponseEntity.ok(planService.createPlan(request));
    }

}

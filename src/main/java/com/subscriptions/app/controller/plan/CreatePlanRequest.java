package com.subscriptions.app.controller.plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlanRequest {
    private Double price;
    private Long ServiceId;
    private String name;
    private String period;
}

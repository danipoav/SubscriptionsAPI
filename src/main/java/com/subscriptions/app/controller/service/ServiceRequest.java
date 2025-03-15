package com.subscriptions.app.controller.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    private String name;
    private String description;
    private String logo;
}

package com.subscriptions.app.controller.subscriptions;

import java.time.LocalDate;

import com.subscriptions.app.model.Plan;
import com.subscriptions.app.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionsRequest {
    private LocalDate renewal_date;
    private LocalDate start_date;
    private User user;
    private Plan plan;
}

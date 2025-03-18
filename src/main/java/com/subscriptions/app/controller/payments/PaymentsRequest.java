package com.subscriptions.app.controller.payments;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentsRequest {
    private double amount;
    private LocalDate payment_date;
    private Long subscribeId;
    private String state;
}

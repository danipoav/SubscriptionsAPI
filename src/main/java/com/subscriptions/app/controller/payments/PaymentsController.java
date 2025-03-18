package com.subscriptions.app.controller.payments;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptions.app.model.Payment;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentsController {

    private final PaymentsService paymentsService;

    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }

    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentsService.getPaymentById(id));
    }

    public ResponseEntity<Payment> createPayment(@RequestBody PaymentsRequest request) {
        return ResponseEntity.ok(paymentsService.createPayment(request));
    }

    public ResponseEntity<Payment> updatePayment(@RequestBody PaymentsRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(paymentsService.updatePayment(request, id));
    }

    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentsService.deletePayment(id);
        return ResponseEntity.ok("Payment removed correctly");
    }

}

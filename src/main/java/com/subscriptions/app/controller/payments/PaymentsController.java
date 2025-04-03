package com.subscriptions.app.controller.payments;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subscriptions.app.model.Payment;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
@CrossOrigin
public class PaymentsController {

    private final PaymentsService paymentsService;

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentsService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentsService.getPaymentById(id));
    }

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody PaymentsRequest request) {
        return ResponseEntity.ok(paymentsService.createPayment(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@RequestBody PaymentUpdate request, @PathVariable Long id) {
        return ResponseEntity.ok(paymentsService.updatePayment(request, id));
    }

    @DeleteMapping("/{sub_id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long sub_id) {
        return ResponseEntity.ok(paymentsService.deletePayment(sub_id));
    }

}

package com.subscriptions.app.controller.payments;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptions.app.model.Payment;
import com.subscriptions.app.model.Subscribe;
import com.subscriptions.app.repository.PaymentRepository;
import com.subscriptions.app.repository.SubscribeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentsService {

    private final PaymentRepository paymentRepository;
    private final SubscribeRepository subscribeRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not founded"));
    }

    public Payment createPayment(PaymentsRequest request) {
        Subscribe subscribe = subscribeRepository.findById(request.getSubscribeId())
                .orElseThrow(() -> new RuntimeException("Subscritiption not founded"));
        var payment = Payment.builder()
                .amount(request.getAmount())
                .paymentDate(request.getPayment_date())
                .subscribe(subscribe)
                .state(request.getState())
                .build();
        paymentRepository.save(payment);
        return payment;
    }

    public Payment updatePayment(PaymentsRequest request, Long id) {
        Subscribe subscribe = subscribeRepository.findById(request.getSubscribeId())
                .orElseThrow(() -> new RuntimeException("Subscritiption not founded"));
        Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not founded"));
        payment.setAmount(request.getAmount());
        payment.setPaymentDate(request.getPayment_date());
        payment.setSubscribe(subscribe);
        payment.setState(request.getState());
        return payment;
    }

    public void deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new RuntimeException("Payment not founded");
        }
        paymentRepository.deleteById(id);
    }

}

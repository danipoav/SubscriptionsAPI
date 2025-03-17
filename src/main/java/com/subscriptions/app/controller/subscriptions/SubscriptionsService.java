package com.subscriptions.app.controller.subscriptions;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptions.app.model.Plan;
import com.subscriptions.app.model.Subscribe;
import com.subscriptions.app.model.User;
import com.subscriptions.app.repository.PlanRepository;
import com.subscriptions.app.repository.SubscribeRepository;
import com.subscriptions.app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscriptionsService {

    private final SubscribeRepository subscribeRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    public List<Subscribe> getAllSubscriptions() {
        return subscribeRepository.findAll();
    }

    public Subscribe getSubscriptionById(Long id) {
        return subscribeRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription Not founded"));
    }

    public Subscribe createSubscription(SubscriptionsRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not founded"));
        Plan plan = planRepository.findById(request.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan not founded"));

        var subscribe = Subscribe.builder()
                .plan(plan)
                .user(user)
                .startDate(LocalDate.now())
                .renewalDate(LocalDate.now().plusMonths(1))
                .build();
        subscribeRepository.save(subscribe);
        return subscribe;

    }

    public Subscribe updateSubscription(Long id, SubscriptionsRequest updatedSubscription) {
        return null;
    }

    public void deleteSubscription(Long id) {
        subscribeRepository.deleteById(id);
    }
}

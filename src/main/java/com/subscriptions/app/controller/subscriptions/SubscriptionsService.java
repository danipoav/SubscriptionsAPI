package com.subscriptions.app.controller.subscriptions;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.subscriptions.app.model.Subscribe;
import com.subscriptions.app.repository.SubscribeRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubscriptionsService {

    private final SubscribeRepository subscribeRepository;

    public List<Subscribe> getAllSubscriptions() {
        return subscribeRepository.findAll();
    }

    public Optional<Subscribe> getSubscriptionById(Long id) {
        return subscribeRepository.findById(id);
    }

    public Subscribe createSubscription(SubscriptionsRequest subscription) {
        return null;
    }

    public Subscribe updateSubscription(Long id, SubscriptionsRequest updatedSubscription) {
        return null;
    }

    public void deleteSubscription(Long id) {
        subscribeRepository.deleteById(id);
    }
}

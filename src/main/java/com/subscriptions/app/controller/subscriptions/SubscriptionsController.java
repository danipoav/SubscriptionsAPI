package com.subscriptions.app.controller.subscriptions;

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

import com.subscriptions.app.model.Subscribe;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subscribe")
@RequiredArgsConstructor
@CrossOrigin
public class SubscriptionsController {

    private final SubscriptionsService subscriptionsService;

    @PostMapping
    public ResponseEntity<Subscribe> createSubscription(@RequestBody SubscriptionsRequest request) {
        return ResponseEntity.ok(subscriptionsService.createSubscription(request));
    }

    @GetMapping
    public ResponseEntity<List<Subscribe>> getAllSubscribes() {
        return ResponseEntity.ok(subscriptionsService.getAllSubscriptions());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Subscribe>> getSubscribeByService(@PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionsService.getSubscriptionById(userId));
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateService(@PathVariable Long id, @RequestBody SubscriptionsRequest request) {
        return ResponseEntity.ok("Falta implementgar");
    }

    // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        subscriptionsService.deleteSubscription(id);
        return ResponseEntity.ok("Subscription removed Correctly!");
    }

}

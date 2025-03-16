package com.subscriptions.app.controller.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subscriptions.app.repository.ServiceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public com.subscriptions.app.model.Service createService(ServiceRequest request) {
        var service = com.subscriptions.app.model.Service.builder()
                .name(request.getName())
                .description(request.getDescription())
                .logo(request.getLogo())
                .build();
        serviceRepository.save(service);
        return service;
    }

    public List<com.subscriptions.app.model.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public com.subscriptions.app.model.Service getServiceById(Long serviceId) {
        return serviceRepository.findById(serviceId).orElseThrow(() -> new RuntimeException("No service founded"));
    }

    public com.subscriptions.app.model.Service updateService(Long id, ServiceRequest request) {
        com.subscriptions.app.model.Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No service founded"));
        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setLogo(request.getLogo());
        return service;
    }

    public void deleteService(Long id) {

        if (!serviceRepository.existsById(id)) {
            throw new RuntimeException("Service not founded");
        }
        serviceRepository.deleteById(id);
    }

}


        package com.placementpro.placementprobackend.controller;

import com.placementpro.placementprobackend.model.ConnectionRequest;
import com.placementpro.placementprobackend.repository.ConnectionRequestRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/connections")
@CrossOrigin
public class ConnectionRequestController {

    private final ConnectionRequestRepository connectionRequestRepository;

    public ConnectionRequestController(
            ConnectionRequestRepository connectionRequestRepository) {
        this.connectionRequestRepository = connectionRequestRepository;
    }

    @PostMapping("/send")
    public ConnectionRequest sendRequest(
            @RequestBody ConnectionRequest request) {

        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());

        return connectionRequestRepository.save(request);
    }

    @GetMapping
    public List<ConnectionRequest> getAllRequests() {
        return connectionRequestRepository.findAll();
    }
}

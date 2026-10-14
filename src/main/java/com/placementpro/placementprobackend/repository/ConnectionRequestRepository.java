
        package com.placementpro.placementprobackend.repository;

import com.placementpro.placementprobackend.model.ConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectionRequestRepository
        extends JpaRepository<ConnectionRequest, Long> {
}

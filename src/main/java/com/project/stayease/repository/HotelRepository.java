package com.project.stayease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stayease.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // Add custom queries if needed
}

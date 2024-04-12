package com.project.stayease.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stayease.DTOs.HotelDTO;
import com.project.stayease.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private static final Logger logger = LoggerFactory.getLogger(HotelController.class);

    @Autowired
    private HotelService hotelService;
    
    
    @GetMapping
    public List<HotelDTO> getAllHotels() {
        logger.info("Fetching all hotels.");
        return hotelService.getAllHotels();
    }

    

}

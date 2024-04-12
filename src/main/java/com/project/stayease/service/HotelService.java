package com.project.stayease.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stayease.DTOs.HotelDTO;
import com.project.stayease.model.Hotel;
import com.project.stayease.repository.HotelRepository;

@Service
public class HotelService {
    private static final Logger logger = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<HotelDTO> getAllHotels() {
        logger.info("Fetching all hotels from the database.");
        List<Hotel> hotels = hotelRepository.findAll();
        return hotels.stream()
                     .map(hotel -> modelMapper.map(hotel, HotelDTO.class))
                     .collect(Collectors.toList());
    }


}

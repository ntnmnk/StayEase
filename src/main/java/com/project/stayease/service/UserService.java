package com.project.stayease.service;

import com.project.stayease.DTOs.UserDTO;
import com.project.stayease.model.User;
import com.project.stayease.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

  private static final Logger logger = LoggerFactory.getLogger(
    UserService.class
  );

  @Autowired
  private UserRepository userRepository;

  @Autowired
  ModelMapper modelMapper;

  public List<UserDTO> getAllUsers() {
    logger.info("Fetching all users from the database.");
    List<User> users = userRepository.findAll();
    return users
      .stream()
      .map(user -> modelMapper.map(user, UserDTO.class))
      .collect(Collectors.toList());
  }

  public UserDTO getUserById(Long id) {
    logger.info("Fetching user with id: {}", id);
    User user = userRepository.findById(id)
                              .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    return modelMapper.map(user, UserDTO.class);
}


public void deleteUser(Long id) {
    logger.info("Deleting user with id: {}", id);
    User user = userRepository.findById(id)
                              .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    userRepository.delete(user);
}

}

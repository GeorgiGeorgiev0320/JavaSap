package com.rungroup.web10.services;

import com.rungroup.web10.dto.RegistrationDto;
import com.rungroup.web10.models.UserEntity;

public interface UserService {
  void saveUser(RegistrationDto registrationDto);

  UserEntity findByEmail(String email);

  UserEntity findByUsername(String username);
}

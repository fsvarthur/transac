package com.example.transaction.Service;

import com.example.transaction.Entity.DTO.UserDto;
import com.example.transaction.Entity.UserEntity;
import com.example.transaction.Exceptions.EmailExistsException;

public interface UserService {

   UserEntity registerNewUserAccount(UserDto userDto) throws EmailExistsException;
}

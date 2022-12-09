package com.example.transaction.User;

import com.example.transaction.Exceptions.EmailExistsException;
import com.example.transaction.User.dto.UserDto;

public interface UserService {

   UserEntity registerNewUserAccount(UserDto userDto) throws EmailExistsException;
}

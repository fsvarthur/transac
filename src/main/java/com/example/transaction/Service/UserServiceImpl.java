package com.example.transaction.Service;

import com.example.transaction.Entity.DTO.UserDto;
import com.example.transaction.Entity.UserEntity;
import com.example.transaction.Exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity registerNewUserAccount(UserDto userDto) throws EmailExistsException {
        if(emailExists(userDto.getEmail())){
            throw new EmailExistsException(
                    "Email exists");
        }
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //user.setRole(new Role(Integer.valueOf(1), user));
        return null;
    }

    private boolean emailExists(String email) {
        return true;
    }
}

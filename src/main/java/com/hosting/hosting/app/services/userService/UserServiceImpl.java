package com.hosting.hosting.app.services.userService;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entities.UserEntity;
import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.passwordEncoder= passwordEncoder;
        this.userRepository = userRepository;
    }


    @Override
    public User login(String email, String password) {
        Optional<UserEntity> optional = userRepository.findByEmail(email);
        if(optional.isPresent()){
            User user = new User();
            UserEntity userEntity = optional.get();
            BeanUtils.copyProperties(userEntity, user);
            if(passwordEncoder.encode(password)!=user.getPassword()){
                return null;
            }
            return user;
        }
        return null;
    }

    @Override
    public String register(User user) {
        Optional<UserEntity> optional = userRepository.findByEmail(user.getEmail());
        if(!optional.isPresent()){
            UserEntity userEntity =new UserEntity();
            BeanUtils.copyProperties(user,userEntity);
            userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
            return "Register Successfully";
        }
        return "User Already Exits";
    }
    
}

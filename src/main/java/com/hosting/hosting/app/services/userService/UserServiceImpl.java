package com.hosting.hosting.app.services.userService;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entities.UserEntity;
import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.repository.UserRepository;
import com.hosting.hosting.app.services.walletService.WalletService;



@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private WalletService walletService;

    UserServiceImpl(UserRepository userRepository,WalletService walletService ){
        this.walletService = walletService;
        this.userRepository = userRepository;
    }


    @Override
    public User login(String email, String password) {
        Optional<UserEntity> optional = userRepository.findByEmail(email);
        if(optional.isPresent()){
            User user = new User();
            UserEntity userEntity = optional.get();
            BeanUtils.copyProperties(userEntity, user);
            if(!password.equals(user.getPassword())){
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
            userEntity.setPassword((user.getPassword()));
            userRepository.save(userEntity);
            walletService.createWallet(user.getEmail());
            return "Register Successfully";
        }
        return "User Already Exits";
    }
    
}

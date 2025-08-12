package com.hosting.hosting.app.service.user;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entity.UserDetailEntity;
import com.hosting.hosting.app.entity.UserEntity;
import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.model.UserDetail;
import com.hosting.hosting.app.repository.UserDetailRepository;
import com.hosting.hosting.app.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
public class UserServicesImpl implements UserServices{

    

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public String saveUser(UserDetail userDetail, User user) {
        try{
            Optional<UserDetailEntity> optional = userDetailRepository.findByUsername(userDetail.getUsername());
            
            if(!optional.isPresent()){
                userDetail.setRoles(Arrays.asList("USER"));
                user.setUsername(userDetail.getUsername());
                UserDetailEntity userDetailEntity = new UserDetailEntity();
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(user,userEntity);
                userDetail.setPassword( passwordEncoder.encode(userDetail.getPassword()));
                BeanUtils.copyProperties(userDetail,userDetailEntity);
                userRepository.save(userEntity);
                userDetailRepository.save(userDetailEntity);
                return "Register Succesfull";
            }
            return "User exists";
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the user", e);
        }
    }


    @Override
    public UserDetail updateUserDetail(UserDetail userdetail) {
        Optional<UserDetailEntity> optional = userDetailRepository.findByUsername(userdetail.getUsername());            
        if(optional.isPresent()){
            optional.get().setPassword(passwordEncoder.encode(userdetail.getPassword()));
            userDetailRepository.save(optional.get());    
            return userdetail;  
        }
        return null;
    }


    @Override
    public User updateUser(User user) {
        Optional<UserDetailEntity> optional = userDetailRepository.findByUsername(user.getUsername());
        if(optional.isPresent()){
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(user,userEntity);
            userRepository.save(userEntity);
        }
        return null;

    }


    @Override
    public String saveSubAdmin(UserDetail userDetail, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveSubAdmin'");
    }


    @Override
    public String deleteUser(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

   
    
    
}

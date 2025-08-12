package com.hosting.hosting.app.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hosting.hosting.app.entity.UserDetailEntity;
import com.hosting.hosting.app.repository.UserDetailRepository;


@Service
public class UserDetailServicesImpl implements UserDetailsService {
    @Autowired
    private UserDetailRepository userdetailRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetailEntity> optional =  userdetailRepository.findByUsername(username);
        if(optional.isPresent()){
            return User.builder()
            .username(username)
            .password(optional.get().getPassword())
            .roles(optional.get().getRoles().toArray(new String[0]))
            .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}

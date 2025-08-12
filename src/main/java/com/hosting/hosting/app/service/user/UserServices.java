package com.hosting.hosting.app.service.user;

import com.hosting.hosting.app.model.User;
import com.hosting.hosting.app.model.UserDetail;

public interface UserServices {
    public String saveUser(UserDetail userDetail, User user);
   public UserDetail updateUserDetail(UserDetail userdetail);
    public User updateUser(User user);
    public String saveSubAdmin(UserDetail userDetail, User user);
    public String deleteUser(String username); 
}

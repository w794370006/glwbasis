package com.glw.basis.item.business.app.service;

import com.glw.basis.item.data.model.User;

public interface IUserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}

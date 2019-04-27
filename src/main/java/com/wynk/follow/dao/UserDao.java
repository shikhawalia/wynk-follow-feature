package com.wynk.follow.dao;

import com.wynk.follow.dao.model.User;
import com.wynk.follow.exception.EntityNotFoundException;

import java.util.List;

public interface UserDao {


    List<User> getAllUsers();
    User getUserById(String id) throws EntityNotFoundException;
    void addArtist(String userId, List<String> artistId) throws EntityNotFoundException;
}

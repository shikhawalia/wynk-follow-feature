package com.wynk.follow.dao.impl;

import com.wynk.follow.dao.UserDao;
import com.wynk.follow.dao.model.Artist;
import com.wynk.follow.dao.model.User;
import com.wynk.follow.exception.EntityNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class UserDaoImpl implements UserDao{

    private Map<String, User> users;

    @PostConstruct
    public void initializeUsers() {
        users = new HashMap<String, User>();
        users.put("u1",new User("u1", "User 1", new ArrayList<String>(Arrays.asList("a1"))));
        users.put("u2",new User("u2", "User 2", new ArrayList<String>(Arrays.asList("a1","a2"))));
        users.put("u3",new User("u3", "User 3", new ArrayList<String>(Arrays.asList("a1"))));

    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<User>(users.values());
    }

    @Override
    public User getUserById(String id) throws EntityNotFoundException {
        if(users.get(id) == null)
            throw new EntityNotFoundException("User ID : " + id + " not found");
        return users.get(id);
    }

    @Override
    public void addArtist(String userId, List<String> artistId) throws EntityNotFoundException {
        if(users.get(userId) == null)
            throw new EntityNotFoundException("User ID : " + userId + " not found");
        users.get(userId).getFollowedArtists().addAll(artistId);
    }
}

package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.User;

import util.UserNotFoundException;

public class UserService {

    private Map<Integer, User> userMap = new HashMap<>();

    // CREATE
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    // READ ALL
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    // READ BY ID
    public User getUserById(int id) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User not found!");
        }
        return userMap.get(id);
    }

    // UPDATE
    public void updateUser(int id, String newName) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User not found!");
        }

        userMap.get(id).setName(newName);
    }

    // DELETE
    public void deleteUser(int id) {
        if (!userMap.containsKey(id)) {
            throw new UserNotFoundException("User not found!");
        }

        userMap.remove(id);
    }
}
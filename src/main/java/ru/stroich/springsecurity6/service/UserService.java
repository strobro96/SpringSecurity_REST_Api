package ru.stroich.springsecurity6.service;

import ru.stroich.springsecurity6.model.User;

import java.util.List;


public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public void updateUser (User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);

    public User findByUsername(String username);
}

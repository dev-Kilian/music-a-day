package com.musicaday.api.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.musicaday.api.models.UserEntity;
import com.musicaday.api.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public List <UserEntity> getUsersByUsername(String searchText) {
        return userRepository.findAll().stream()
            .filter(user -> user.getUsername().toLowerCase().contains(searchText.toLowerCase()))
            .collect(Collectors.toList());
    }

    public Optional<UserEntity> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public UserEntity addUser (UserEntity user) {
        userRepository.save(user);
        return user;
    }

    public UserEntity updateUser(UserEntity updatedUser) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(updatedUser.getUsername());

        if (existingUser.isPresent()){
            UserEntity userToUpdate = existingUser.get();

            userToUpdate.setUsername(updatedUser.getUsername());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());
            userToUpdate.setResults(updatedUser.getResults());

            userRepository.save(userToUpdate);
            return userToUpdate;
        }
        return null;
    }

    @Transactional
    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }
}

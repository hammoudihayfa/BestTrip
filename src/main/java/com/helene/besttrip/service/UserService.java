package com.helene.besttrip.service;

import com.helene.besttrip.entities.User;
import com.helene.besttrip.repositry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        @Autowired
        private UserRepository userRepository;

        // Créer un utilisateur
        public User createUser(User user) {
            return userRepository.save(user);
        }

        // Récupérer un utilisateur par ID
        public User getUserById(Long id) {
            return userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        // Récupérer tous les utilisateurs
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        // Mettre à jour un utilisateur
        public User updateUser(Long id, User userDetails) {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            user.setNom(userDetails.getNom());
            user.setEmail(userDetails.getEmail());

            user.setRole(userDetails.getRole());

            return userRepository.save(user);
        }

        // Supprimer un utilisateur
        public void deleteUser(Long id) {
            userRepository.deleteById(id);
        }
    }


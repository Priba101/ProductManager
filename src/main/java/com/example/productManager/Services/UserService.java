package com.example.productManager.Services;

import com.example.productManager.Models.Role;
import com.example.productManager.Models.User;
import com.example.productManager.Repositories.RoleRepository;
import com.example.productManager.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role userRole = roleRepository.findByRole("SITE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

}

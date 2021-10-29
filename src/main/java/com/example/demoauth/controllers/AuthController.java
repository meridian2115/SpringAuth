package com.example.demoauth.controllers;

import com.example.demoauth.configs.jwt.JwtUtils;
import com.example.demoauth.models.ERole;
import com.example.demoauth.models.Role;
import com.example.demoauth.models.User;
import com.example.demoauth.pojo.JwtResponse;
import com.example.demoauth.pojo.LoginRequest;
import com.example.demoauth.pojo.MessageResponse;
import com.example.demoauth.pojo.SignupRequest;
import com.example.demoauth.repository.RoleRepository;
import com.example.demoauth.repository.UserRepository;
import com.example.demoauth.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Fedor Danilov 29.10.2021
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest){

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
        if (userRepository.existsByUsername(signupRequest.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: username is exist"));
        }
        if (userRepository.existsByEmail(signupRequest.getEmail())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is exist"));
        }
        User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getLastName(),signupRequest.getFirstName(),signupRequest.getPatronymic());
        Set<String> reqRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (reqRoles == null ){
            Role userRole = roleRepository
                    .findByName(ERole.ROLE_USER)
                    .orElseThrow(()->new RuntimeException("Error! Role USER is not found"));
            roles.add(userRole);
        } else{
            reqRoles.forEach(r->{
                switch (r){
                    case "admin":
                        Role adminRole = roleRepository
                                .findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(()->new RuntimeException("Error! Role ADMIN is not found"));
                        roles.add(adminRole);
                        break;
                    case "mod":
                        Role modRole = roleRepository
                                .findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(()->new RuntimeException("Error! Role MODERATOR is not found"));
                        roles.add(modRole);
                        break;
                    default:
                        Role userRole = roleRepository
                                .findByName(ERole.ROLE_USER)
                                .orElseThrow(()->new RuntimeException("Error! Role USER is not found"));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User CREATED"));

    }
}

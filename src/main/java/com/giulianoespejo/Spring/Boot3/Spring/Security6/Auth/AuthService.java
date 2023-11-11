package com.giulianoespejo.Spring.Boot3.Spring.Security6.Auth;

import com.giulianoespejo.Spring.Boot3.Spring.Security6.Jwt.JwtService;
import com.giulianoespejo.Spring.Boot3.Spring.Security6.User.Role;
import com.giulianoespejo.Spring.Boot3.Spring.Security6.User.User;
import com.giulianoespejo.Spring.Boot3.Spring.Security6.User.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;


    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password( request.getPassword())
                .firstname(request.getFirstname())
                .lastname(request.lastname)
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();

    }

}

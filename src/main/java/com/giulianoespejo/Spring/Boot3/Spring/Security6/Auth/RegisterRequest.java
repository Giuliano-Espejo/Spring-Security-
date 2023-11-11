package com.giulianoespejo.Spring.Boot3.Spring.Security6.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    String country;
}

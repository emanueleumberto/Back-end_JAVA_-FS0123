package com.epicode.project.security.payload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String creditCard;
    private String secretCode;
    private String alfaCode;
    // Passagio di ruoli dal client (Facoltativo)
    private Set<String> roles;
}

// Il client dovrà inviare un oggetto JSON nel body con questa forma
/*{
    "name": "Francesca",
    "lastname": "Neri",
    "username": "francescaneri",
    "email": "f.neri@example.com",
    "password": "qwerty",
    "creditCard": "1234 5678 9999",
    "secretCode": "12345",
    "alfaCode": "A1b2-!Z",
    "roles": ["MODERATOR", "USER"]
}*/

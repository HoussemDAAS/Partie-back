package com.houssem.users.services.register;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@AllArgsConstructor 
@NoArgsConstructor
public class RegistationRequest {
private String username;
private String password;
private String email;
}

package com.user.userSecurity.Model;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max = 20, min = 3, message = "Invalid Name, Size should be between 3 to 20")
	@NotEmpty(message = "Please enter your name")
	private String name;
	
    @NotEmpty(message = "Please enter your phoneNumber")
    @Max(value = 10, message = "Invalid PhoneNumber, Maximum allowed is 10")
	private String phoneNumber;
	
    @Size(max = 20, min = 5, message = "Invalid Name, Size should be between 5 to 20")
    @NotEmpty(message = "Please enter your password")
	private String password;
	

}

package com.example.User.Model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_usernew")
public class User {
	
	@Id
	private Integer userId;
	private String  name;
	private String email;
	private String phoneNumber;
}

package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
	
	
	
	
}

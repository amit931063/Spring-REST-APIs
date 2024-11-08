package com.amit.springbootwebtutorial.springbootwebtutorial.entities;
import com.amit.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employees")
public class EmployeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String email;
    private Integer age;
    private String role;
    private LocalDate dateofJoining;
    @JsonProperty("isActive")
    private Boolean isActive;


}
package com.amit.springbootwebtutorial.springbootwebtutorial.dto;
import com.amit.springbootwebtutorial.springbootwebtutorial.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

@NotNull
     private Long id;
     @NotBlank(message="email should not be blank")
     private String name;
     @NotNull
     @NotEmpty
     private  String email;
   private  Integer age;
   @EmployeeRoleValidation
   private String role;
  private LocalDate dateofJoining ;
  @JsonProperty("isActive")
   private Boolean isActive;
}






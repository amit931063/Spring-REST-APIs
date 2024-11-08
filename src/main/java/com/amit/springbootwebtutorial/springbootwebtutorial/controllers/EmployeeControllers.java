package com.amit.springbootwebtutorial.springbootwebtutorial.controllers;
import com.amit.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.amit.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.amit.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path= "/employee")

public class EmployeeControllers {
    private final EmployeeService employeeservice;
    private final ModelMapper modelmapper;
    public EmployeeControllers(EmployeeService employeeservice, ModelMapper modelmapper) {
        this.employeeservice = employeeservice;
        this.modelmapper = modelmapper;
    }


    @GetMapping(path= "/{employeeid}")
    public ResponseEntity<EmployeeDTO>employeegetId(@PathVariable (name="employeeid")   Long id){
        Optional<EmployeeDTO>employeeDTO= (employeeservice.employeegetId(id));
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElseThrow(()-> new ResourceNotFoundException("employee was not found " +id));
    }

    @GetMapping
   public ResponseEntity<List<EmployeeDTO>>getAllEmplyees(@RequestParam (required = false,name="inputAge")Integer age, @RequestParam( required = false)String sortBy)
    {

        return ResponseEntity.ok(employeeservice.getAllEmplyees());
    }
@PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee( @RequestBody   @Valid EmployeeDTO inputEmployee){
        EmployeeDTO savedemployeeDTO=employeeservice.createEmployee(inputEmployee);
        return new  ResponseEntity<>(savedemployeeDTO, HttpStatus.CREATED);
}
@PutMapping(path= "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployebyId(@RequestBody   @Valid  EmployeeDTO employeeDTO , @PathVariable   Long employeeId){
        return ResponseEntity.ok(employeeservice.updateEmployebyId(employeeId,employeeDTO));

}
@DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployebyId( @PathVariable Long employeeId){
        boolean deleted=employeeservice.deleteEmployebyId(employeeId);
        if(deleted) return ResponseEntity.ok(true);
        return  ResponseEntity.notFound().build();
    }
    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO>updatePartiallyEmployebyId(@PathVariable Long employeeId, @RequestBody Map<String,Object>updates){
        EmployeeDTO employeeDTO= employeeservice.updatePartiallyEmployebyId(employeeId,updates);
        if(employeeDTO==null)  return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);


    }
}


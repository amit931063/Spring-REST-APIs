package com.amit.springbootwebtutorial.springbootwebtutorial.services;

import com.amit.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.amit.springbootwebtutorial.springbootwebtutorial.entities.EmployeEntity;
import com.amit.springbootwebtutorial.springbootwebtutorial.exceptions.ResourceNotFoundException;
import com.amit.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeerepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeerepository, ModelMapper modelMapper) {
        this.employeerepository = employeerepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> employeegetId(Long id) {
//       Optional<EmployeEntity>employeeentities=employeerepository.findById(id);
//        return employeeentities.map(employeeentities1-> modelMapper.map(employeeentities1,employeDTO.clas));
return employeerepository.findById(id).map( employeEntity -> modelMapper.map(employeEntity, EmployeeDTO.class));
    }

    public List<EmployeeDTO> getAllEmplyees() {
       List<EmployeEntity> employeeentities=employeerepository.findAll();
       return employeeentities.stream()
               .map(EmployeEntity->modelMapper.map(EmployeEntity, EmployeeDTO.class))
        .collect(Collectors.toList());

    }

    public EmployeeDTO createEmployee(EmployeeDTO inputEmployee) {
       EmployeEntity  tosaveEmployeEntity=modelMapper.map( inputEmployee,EmployeEntity.class);
       EmployeEntity savedEmployeEntity=employeerepository.save( tosaveEmployeEntity );
       return modelMapper.map(savedEmployeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployebyId(Long employeeId , EmployeeDTO employeeDTO) {
        isExistById(employeeId);
        EmployeEntity employeEntity=modelMapper.map(employeeDTO, EmployeEntity.class);
        employeEntity.setId(employeeId);
        EmployeEntity savedemplyeeEntity=employeerepository.save(employeEntity);
                return modelMapper.map(savedemplyeeEntity, EmployeeDTO.class);
    }
    public boolean isExistById( Long employeeId){
        boolean exist= employeerepository.existsById(employeeId);
        if(!exist) throw  new ResourceNotFoundException("resource was not found "+employeeId);
        return true;

    }

    public boolean deleteEmployebyId(Long employeeId) {
        isExistById(employeeId);
        employeerepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDTO updatePartiallyEmployebyId(Long employeeId, Map<String, Object> updates) {
        isExistById(employeeId);
        EmployeEntity employeEntity=employeerepository.findById(employeeId).get();
        updates.forEach((field,value)-> {
         Field fieldtobeUpdated = ReflectionUtils.findRequiredField(EmployeEntity.class,field);
            fieldtobeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldtobeUpdated,employeEntity,value);
        });
        return  modelMapper.map(employeerepository.save(employeEntity) ,EmployeeDTO.class);
    }
}

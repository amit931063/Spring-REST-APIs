package com.amit.springbootwebtutorial.springbootwebtutorial.repositories;

import com.amit.springbootwebtutorial.springbootwebtutorial.entities.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeEntity, Long> {

}

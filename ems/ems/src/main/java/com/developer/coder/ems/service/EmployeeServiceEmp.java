package com.developer.coder.ems.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.coder.ems.Entity.Employee;
import com.developer.coder.ems.dto.EmployeeDTO;
import com.developer.coder.ems.exception.EmployeeResourceNotFoundException;
import com.developer.coder.ems.mapper.EmployeeMapper;
import com.developer.coder.ems.repository.EmployeeRepository;

import lombok.AllArgsConstructor;


//@AllArgsConstructor
@Service
public class EmployeeServiceEmp implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public EmployeeDTO createNewEmployee(EmployeeDTO employeedto) {
		Employee newEmployee = EmployeeMapper.mapToEmployee(employeedto);
		Employee savedEmployee= employeeRepository.save(newEmployee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> allEmployees = employeeRepository.findAll();
		return allEmployees.stream().map((e)-> EmployeeMapper.mapToEmployeeDto(e)).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO getEmployeeById(Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeResourceNotFoundException("Employee Id Requested doesn't exist....") );
		
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public EmployeeDTO updateEmployeeById(Long id, EmployeeDTO employeeDto) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new EmployeeResourceNotFoundException("Employee Id requested doesn't exist...."));
		
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		Employee employee= employeeRepository.findById(id).orElseThrow(()->new EmployeeResourceNotFoundException("not Id"));
			employeeRepository.deleteById(id);
	}
		
	
	

	
	
	
	

}

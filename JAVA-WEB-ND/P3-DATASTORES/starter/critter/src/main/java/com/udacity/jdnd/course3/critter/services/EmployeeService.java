package com.udacity.jdnd.course3.critter.services;

import java.util.Set;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;
import com.udacity.jdnd.course3.critter.repositories.EmployeesRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeesRepository employeesRepository;

    public Employee getEmployeeById(long employeeId) {
        return employeesRepository.getOne(employeeId);
    }

    public List<Employee> getEmployeesForService(LocalDate date, Set<EmployeeSkill> skills) {
        List<Employee> employees = employeesRepository.getAllByDaysAvailableContains(date.getDayOfWeek()).stream()
                .filter(employee -> employee.getSkills().containsAll(skills)).collect(Collectors.toList());
        return employees;
    }

    public Employee saveEmployee(Employee employee) {
        return employeesRepository.save(employee);
    }

    public void setEmployeeAvailability(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeesRepository.getOne(employeeId);
        employee.setDaysAvailable(daysAvailable);
        employeesRepository.save(employee);
    }
}

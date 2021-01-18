package com.udacity.jdnd.course3.critter.repositories;

import java.util.List;
import java.time.DayOfWeek;

import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Long> {
    List<Employee> getAllByDaysAvailableContains(DayOfWeek dayOfWeek);
}

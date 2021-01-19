package com.udacity.jdnd.course3.critter.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Employee;
import com.udacity.jdnd.course3.critter.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SchedulesRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> getAllByPetsContains(Pet pet);

    List<Schedule> getAllByPetsIn(List<Pet> pets);

    List<Schedule> getAllByEmployeesContains(Employee employee);

}

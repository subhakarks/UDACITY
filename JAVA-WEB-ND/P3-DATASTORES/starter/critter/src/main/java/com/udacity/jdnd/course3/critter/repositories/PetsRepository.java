package com.udacity.jdnd.course3.critter.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Long> {
    List<Pet> getAllByCustomerId(Long customerId);
}

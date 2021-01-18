package com.udacity.jdnd.course3.critter.repositories;

import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomersRepository extends JpaRepository<Customer, Long> {
}

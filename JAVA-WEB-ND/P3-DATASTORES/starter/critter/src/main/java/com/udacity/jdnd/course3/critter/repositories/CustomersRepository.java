package com.udacity.jdnd.course3.critter.repositories;

import org.springframework.stereotype.Repository;
import com.udacity.jdnd.course3.critter.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomersRepository extends JpaRepository<Customer, Long> {
}

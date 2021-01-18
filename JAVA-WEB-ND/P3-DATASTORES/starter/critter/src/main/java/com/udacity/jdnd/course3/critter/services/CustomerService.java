package com.udacity.jdnd.course3.critter.services;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.udacity.jdnd.course3.critter.entities.Pet;
import com.udacity.jdnd.course3.critter.entities.Customer;
import com.udacity.jdnd.course3.critter.repositories.PetsRepository;
import com.udacity.jdnd.course3.critter.repositories.CustomersRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private PetsRepository petsRepository;

    public List<Customer> getAllCustomers() {
        return customersRepository.findAll();
    }

    public Customer getCustomerByPetId(long petId) {
        return petsRepository.getOne(petId).getCustomer();
    }

    public Customer saveCustomer(Customer customer, List<Long> petIds) {
        List<Pet> pets = new ArrayList<>();
        if (petIds != null && !petIds.isEmpty()) {
            pets = petIds.stream().map((petId) -> petsRepository.getOne(petId)).collect(Collectors.toList());
        }
        customer.setPets(pets);
        return customersRepository.save(customer);
    }
}

package com.udacity.jdnd.course3.critter.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String notes;
    private String phoneNumber;

    @OneToMany(targetEntity = Pet.class)
    private List<Pet> pets;

    /*
     * public Customer(String name, String notes, String phoneNumber) { this.name =
     * name; this.notes = notes; this.phoneNumber = phoneNumber; }
     */

    public void insertPet(Pet pet) {
        pets.add(pet);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}

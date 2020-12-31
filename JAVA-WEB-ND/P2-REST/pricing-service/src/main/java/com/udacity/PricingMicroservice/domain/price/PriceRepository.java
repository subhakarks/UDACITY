package com.udacity.PricingMicroservice.domain.price;

import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}

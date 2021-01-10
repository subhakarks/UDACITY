package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.hasSize;
import com.udacity.PricingMicroservice.PricingServiceApplication;
import com.udacity.PricingMicroservice.domain.price.PriceRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PricingServiceApplication.class)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PriceRepository priceRepository;

    @Test
    public void test_get_price_by_id() throws Exception {
        mockMvc.perform(get("/prices/1")).andExpect(status().isOk()).andExpect(jsonPath("$.vehicleId").exists())
                .andExpect(jsonPath("$.vehicleId").value(1));
    }

    @Test
    public void test_get_all_prices() throws Exception {
        mockMvc.perform(get("/prices/")).andExpect(status().isOk()).andExpect(jsonPath("$._embedded").exists())
                .andExpect(jsonPath("$._embedded.prices").exists())
                .andExpect(jsonPath("$._embedded.prices", hasSize(5)));
    }
}

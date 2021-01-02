package com.udacity.pricing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.udacity.PricingMicroservice.PricingServiceApplication;
import com.udacity.PricingMicroservice.domain.price.PriceRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PricingServiceApplication.class)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PriceRepository priceRepository;

    @Test
    public void testGetRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/services/price?vehicleId=1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listPrices() throws Exception {
        mockMvc.perform(get("/prices/")).andExpect(status().isOk()).andExpect(jsonPath("$._embedded").exists())
                .andExpect(jsonPath("$._embedded.prices").exists())
                .andExpect(jsonPath("$._embedded.prices", hasSize(19)));
    }
}

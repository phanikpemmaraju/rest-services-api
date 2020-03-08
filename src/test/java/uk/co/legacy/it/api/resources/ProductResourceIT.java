package uk.co.legacy.it.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.legacy.it.RestServicesApiApplication;
import uk.co.legacy.it.dto.Product;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by phani16 on 07/03/2020.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestServicesApiApplication.class)
@AutoConfigureMockMvc
public class ProductResourceIT {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProductById() throws Exception{
        final String productId = "1234";
        mvc.perform(MockMvcRequestBuilders.get("/products/" + productId)
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(productId)))
                .andExpect(jsonPath("$.description", is("abc product")))
                .andExpect(jsonPath("$.price", is(10.35)));
    }

    @Test
    public void productIdNotFound() throws Exception{
        final String productId = "4321";
        mvc.perform(MockMvcRequestBuilders.get("/products/" + productId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void postProduct() throws Exception{
        final Product product = Product.builder().productId("12345").build();

        mvc.perform(MockMvcRequestBuilders.post("/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product))).andExpect(status().isAccepted());
    }
}

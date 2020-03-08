package uk.co.legacy.it.api.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.co.legacy.it.api.exceptions.ResourceNotFoundException;
import uk.co.legacy.it.dto.Product;
import uk.co.legacy.it.services.ProductService;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by phani16 on 07/03/2020.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductResource.class)
public class ProductResourceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProductById() throws Exception{
        final String productId = "12345";
        final Product product = Product.builder().productId(productId).build();
        when(service.getProductId(productId)).thenReturn(product);

        mvc.perform(MockMvcRequestBuilders.get("/products/" + productId)
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.productId", is(productId)));

        verify(service).getProductId(productId);
    }

    @Test
    public void productIdNotFound() throws Exception{
        final String productId = "12345";
        when(service.getProductId(productId)).thenThrow(ResourceNotFoundException.class);

        mvc.perform(MockMvcRequestBuilders.get("/products/" + productId)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
    }

    @Test
    public void postProduct() throws Exception{
        final Product product = Product.builder().productId("12345").build();
        when(service.createProduct(product)).thenReturn(product);

        mvc.perform(MockMvcRequestBuilders.post("/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(product))).andExpect(status().isAccepted());
    }
}

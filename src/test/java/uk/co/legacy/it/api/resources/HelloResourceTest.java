package uk.co.legacy.it.api.resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by phani16 on 07/03/2020.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloResource.class)
public class HelloResourceTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void defaultHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Hello to everyone !!!")));
    }

    @Test
    public void sayHello() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/hello/mike")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Hello !!! mike")));
    }
}

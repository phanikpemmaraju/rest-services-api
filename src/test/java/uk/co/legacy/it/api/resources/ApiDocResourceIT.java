package uk.co.legacy.it.api.resources;

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

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by phani16 on 08/03/2020.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestServicesApiApplication.class)
@AutoConfigureMockMvc
public class ApiDocResourceIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void apiDoc() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api-docs.json")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.info.title", is("Legacy IT Rest Services API")))
                .andExpect(jsonPath("$.info.version", is("1.0.0")))
                .andExpect(jsonPath("$.info.description", is("Rest APIs exposed")));
    }
}

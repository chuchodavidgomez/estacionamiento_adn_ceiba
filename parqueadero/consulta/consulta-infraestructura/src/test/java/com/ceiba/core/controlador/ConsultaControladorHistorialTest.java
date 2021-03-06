package com.ceiba.core.controlador;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.core.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ConsultaControladorHistorial.class)
public class ConsultaControladorHistorialTest {

	@Autowired
    private MockMvc mocMvc;

    @Test 
    public void listar() throws Exception {
        // arrange

        // act - assert
    	mocMvc.perform(get("/historial")
    		      .contentType(MediaType.APPLICATION_JSON))
    		      .andExpect(status().isOk())
    		      .andExpect(jsonPath("$", hasSize(1)))
    		      .andExpect(jsonPath("$[0].placaVehiculo", is("aaa111")));
    }
    

}

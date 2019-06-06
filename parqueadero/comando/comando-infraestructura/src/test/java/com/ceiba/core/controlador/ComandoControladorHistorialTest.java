package com.ceiba.core.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.core.ApplicationMock;
import com.ceiba.core.comando.ComandoHistorial;
import com.ceiba.core.testdatabuilder.ComandoHistorialTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorHistorial.class)
public class ComandoControladorHistorialTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/historial/ingresar")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 1}"));
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
    	Long id = 2L;
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/historial/actualizar/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk());
        		//.andExpect(content().("{'pago': 8000}"));
    }
    
    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/historial/eliminar/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

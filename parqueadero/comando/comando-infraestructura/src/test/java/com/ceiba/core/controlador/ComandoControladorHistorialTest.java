package com.ceiba.core.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

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
        		.andExpect(content().json("{'valor': 4}"));
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
    	//Long id = 1;
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/historial/actualizar/{id}",1)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 8000}"));
    }
    
    @Test
    public void actualizar24EnParqueaderoAuto() throws Exception{
        // arrange
    	Long id = (long) 1;
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().conFechaIngreso(LocalDateTime.now()).conFechaSalida(LocalDateTime.now().plusDays(1)).build();

        // act - assert
        mocMvc.perform(put("/historial/actualizar/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 8000}"));
    }
    
    @Test
    public void actualizar24EnParqueaderoMoto() throws Exception{
        // arrange
    	Long id = (long) 3;
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().conFechaIngreso(LocalDateTime.now()).conFechaSalida(LocalDateTime.now().plusDays(1)).conPlacaVehiculo("baa11e").build();

        // act - assert
        mocMvc.perform(put("/historial/actualizar/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 4000}"));
    }
    
    @Test
    public void actualizar24EnParqueaderoMotoConCilindraje600() throws Exception{
        // arrange
    	Long id = (long) 3;
        ComandoHistorial Historial = new ComandoHistorialTestDataBuilder().conFechaIngreso(LocalDateTime.now()).conFechaSalida(LocalDateTime.now().plusDays(1)).conPlacaVehiculo("baa12e").build();

        // act - assert
        mocMvc.perform(put("/historial/actualizar/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(Historial)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 6000}"));
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

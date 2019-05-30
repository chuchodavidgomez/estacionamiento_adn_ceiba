package com.ceiba.core.controlador;

//pruebas de integracion
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.ceiba.core.comando.ComandoVehiculo;
import com.ceiba.core.testdatabuilder.ComandoVehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorVehiculo.class)
public class ComandoControladorVehiculoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/vehiculos/ingresar")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
    	String placa = "abc123";
        ComandoVehiculo vehiculo = new ComandoVehiculoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/vehiculos/{placa}",placa)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());
    }
    
    @Test
    public void eliminar() throws Exception {
        // arrange
        String placa = "abc123";

        // act - assert
        mocMvc.perform(delete("/vehiculos/{placa}",placa)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

package com.example.demo3;

import com.example.demo3.model.Escolaridad;
import com.example.demo3.service.EscolaridadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo3ApplicationTests {

	@Autowired
	EscolaridadService escolaridadService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  testSave() throws Exception{
		Escolaridad escolaridad = getEscolaridad();
		escolaridadService.save(escolaridad);

	}

	public Escolaridad getEscolaridad (){
		Escolaridad escolaridadsave = new Escolaridad();
		escolaridadsave.setCodigo("PRIMARIA");
		escolaridadsave.setDescripcion("Nivel Basico de laeducacion");
		escolaridadsave.setNombre("Primaria");
		escolaridadsave.setRequiereTitulo(true);

		return escolaridadsave;
	}

}

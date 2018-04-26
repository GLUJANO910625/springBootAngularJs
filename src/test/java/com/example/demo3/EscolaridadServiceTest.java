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
public class EscolaridadServiceTest {

	@Autowired
	EscolaridadService escolaridadService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void  testSave() throws Exception{
		Escolaridad escolaridad = getEscolaridad();
		escolaridadService.save(escolaridad);
		escolaridadService.delete(escolaridad);
	}

	@Test
	public void testUpdate() throws Exception{
		//prueba  .
		Escolaridad escolaridad = getEscolaridad();
		escolaridadService.save(escolaridad);

		escolaridad.setDescripcion("Secundaria");
		escolaridadService.update(escolaridad);

		Escolaridad escolaridadUpdate = escolaridadService.getById(escolaridad.getId());
		assert escolaridadUpdate.getDescripcion().trim().equals("Secundaria") : "El m\u00e9todo update no gener\u00f3 el cambio solicitado";
		escolaridadService.delete(escolaridadUpdate);


	}

	public Escolaridad getEscolaridad (){
		Escolaridad escolaridadsave = new Escolaridad();
		escolaridadsave.setCodigo("PRIMARIA");
		escolaridadsave.setDescripcion("Nivel Basico de la educacion");
		escolaridadsave.setNombre("Primaria");
		escolaridadsave.setRequiereTitulo(true);

		return escolaridadsave;
	}

}

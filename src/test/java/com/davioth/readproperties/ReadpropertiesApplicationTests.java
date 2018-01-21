package com.davioth.readproperties;

import com.davioth.readproperties.main.ReadpropertiesApplication;
import com.davioth.readproperties.noSpringBean.ClaseNoSpring;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReadpropertiesApplication.class)
public class ReadpropertiesApplicationTests {

	@Test
	public void lecturaPropiedadEnClaseNoSpring () {
		ClaseNoSpring claseNoSpring = new ClaseNoSpring();
        assertNotNull("Se esperaba la creación de la clase", claseNoSpring);
        assertEquals("Se esperaba que se leyera la propiedad", "readproperties",
                claseNoSpring.getPropertie());

	}

}

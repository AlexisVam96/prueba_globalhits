package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ApiResponseList;
import com.example.demo.service.ProductoService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	private ProductoService productoService;

	@Test
	void prueba01() {
		ApiResponseList<?> resp =  productoService.insertAndListProducts(1, "PRODUCOT 1", LocalDate.of(2024, 4, 22));
		System.out.println("PRUEBA 1");
		System.out.println(resp);
	}
	
	@Test
	void prueba02() {
		ApiResponseList<?> resp =  productoService.insertAndListProducts(2, "PRODUCOT 2", LocalDate.of(2024, 4, 22));
		System.out.println("PRUEBA 2");
		System.out.println(resp);
	}
}

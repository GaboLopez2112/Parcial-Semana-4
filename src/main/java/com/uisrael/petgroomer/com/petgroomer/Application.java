package com.uisrael.petgroomer.com.petgroomer;

import com.uisrael.petgroomer.com.petgroomer.model.ModelProducto;
import com.uisrael.petgroomer.com.petgroomer.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}



package com.rshu.javachat;

import com.rshu.javachat.storage.PDBInterlayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavachatApplication {

	public static void main(String[] args) {
		PDBInterlayer pdbc = new PDBInterlayer();
		System.out.println(pdbc.getUserId("pchel"));
		SpringApplication.run(JavachatApplication.class, args);
	}

}

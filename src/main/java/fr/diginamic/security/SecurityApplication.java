package fr.diginamic.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SecurityApplication.class, args);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String chainDeCaractere = "toto";
		System.out.println(chainDeCaractere +" = " +encoder.encode(chainDeCaractere));
		String chainEncoder = encoder.encode(chainDeCaractere);
		System.out.println(chainEncoder +" = " +encoder.encode(chainDeCaractere));

		String totohaseh = encoder.encode("toto");
		String newotohaseh = encoder.encode("toto");
		System.out.println(encoder.matches("toto", totohaseh));
		System.out.println(encoder.matches("toto", newotohaseh));
	}

}

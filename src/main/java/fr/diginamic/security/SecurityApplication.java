package fr.diginamic.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
		//SpringApplication.run(SecurityApplication.class, args);

		String secretKey = "Diginamic c'est chouette";
		String message = "Voici une chaîne à signer";

		//Crée la clé
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");

		//Initialise le HMAC
		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(secretKeySpec);

		// Calcule le HMAC
		byte[] hmacBytes = mac.doFinal(message.getBytes());

		// Encode en Base 64 ou Hex
		String hmacBase64 = Base64.getEncoder().encodeToString(hmacBytes);
		System.out.println("Signature HMAC-SHA256 (Base64) : " + hmacBase64);
	}

}

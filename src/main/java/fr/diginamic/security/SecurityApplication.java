package fr.diginamic.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

@SpringBootApplication
public class SecurityApplication {

	public static String getHash(String input) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		String hex = HexFormat.of().formatHex(hash);
		return hex;
	}

	public static int getNonce(String prenom) throws NoSuchAlgorithmException {
		int nonce = 0;
		while (true) {
			String neoPrenom = prenom + nonce;
			String hash = getHash(neoPrenom);

			if (hash.startsWith("0000")) {
				return nonce;
			}
			nonce++;
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//SpringApplication.run(SecurityApplication.class, args);
		String[] prenoms = {"Pierre", "Paul", "Jacques"}; // Remplacez par les vrais prénoms

		for (String prenom : prenoms) {
			String hash = getHash(prenom);
			System.out.println("Hash de " + prenom + " : " + hash);
			int nonce = getNonce(prenom);
			System.out.println("Nonce de " + prenom + " : " + nonce);
		}
	}

}

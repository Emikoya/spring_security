package fr.diginamic;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SecurityApplication {

	// Méthode pour valider un JWT
	public static boolean isValidJWT(String jwt, String secretKey) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(secretKey.getBytes())
					.parseClaimsJws(jwt)
					.getBody();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		//SpringApplication.run(SecurityApplication.class, args);

		String secretKey = "maSuperCleSecrete123maSuperCleSecrete123";
		String message = "Voici une chaîne à signer";

		//Generation d'un JWT avec playload = message
		String jwt = Jwts.builder()
				.setSubject("exemple")
				.claim("message", message)
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
				.compact();
		System.out.println("JWT : " + jwt);

		//Décodage / vérification du JWT
		Claims claims = Jwts.parser()
				.setSigningKey(secretKey.getBytes())
				.parseClaimsJws(jwt)
				.getBody();
		System.out.println("Message extrait du JWT : " + claims.get("message"));

		// Tests de validation avec les JWT fournis
		String[] jwtsToTest = {
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGVtcGxlIiwibWVzc2FnZSI6IlZvaWNpIHVuZSBjaGHDrm5lIMOgIHNpZ25lciIsImlhdCI6MTc0NDgzMTMxNX0.VIBNB1C1j93PUDrbmFJwbJXXbTYNPwEGJbkEQHVZoYg",
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGVtcGxlIiwibWVzc2FnZSI6IlZvaWNpIHVuZSBjaGHDrm5lIMOgIHNpZ25lciIsImlhdCI6MTc0NDgzMTYwNn0.UZ6IO0Wvrnd4NP63diYjyvkNFNWI1NfDGP9lpfJyJSE",
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGVtcGxlIiwibWVzc2FnZSI6IlZvaWNpIHVuZSBjaGHDrm5lIMOgIHRpZ25lciIsImlhdCI6MTc0NDgzMTY0NX0.5vpcu1T7DmXDuoCBLhBJAQGE3HpNUO41-Tr0rkGrDY0",
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGVtcGxlIiwibWVzc2FnZSI6IlZvaWNpIHVuZSBjaGHDrm5lIMOgIHNpZ25lciIsImlhdCI6MTc0NDgzMTY3OH0.NXvOGwyMKQ9tK2z5dR6ER5tbf2plLlkxgJnCQ0lI13g"
		};
		System.out.println("\nTests de validation :");
		for (int i = 0; i < jwtsToTest.length; i++) {
			boolean isValid = isValidJWT(jwtsToTest[i], secretKey);
			System.out.println("JWT " + jwtsToTest[i] + " est " + (isValid ? "valide" : "invalide"));
		}
	}

}

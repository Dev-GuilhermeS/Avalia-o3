package br.edu.ifsp.mecanica.security;

import br.edu.ifsp.mecanica.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario){

        try {

            var algoritmo = Algorithm.HMAC256("12345678");

            return JWT.create()
                    .withIssuer("MECANICA")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(
                            LocalDateTime.now()
                                    .plusHours(2)
                                    .toInstant(ZoneOffset.of("-03:00"))
                    )
                    .sign(algoritmo);

        }
        catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token");
        }
    }

    public String validarToken(String token){

        try {

            var algoritmo = Algorithm.HMAC256("12345678");

            return JWT.require(algoritmo)
                    .withIssuer("MECANICA")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException e){
            e.printStackTrace();
            return "";
        }
    }
}
package br.edu.ifsp.mecanica.controller;

import br.edu.ifsp.mecanica.usuario.DadosAutenticacao;
import br.edu.ifsp.mecanica.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ifsp.mecanica.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Autowired
    private PasswordEncoder encoder;

    public AutenticacaoController(
            AuthenticationManager manager,
            TokenService tokenService) {

        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(
            @RequestBody DadosAutenticacao dados){

        try {

            System.out.println("LOGIN RECEBIDO: " + dados.login());

            var tokenAutenticacao =
                    new UsernamePasswordAuthenticationToken(
                            dados.login(),
                            dados.senha()
                    );


            var authentication =
                    manager.authenticate(tokenAutenticacao);

            System.out.println("AUTENTICADO COM SUCESSO");

            var token =
                    tokenService.gerarToken(
                            (Usuario) authentication.getPrincipal()
                    );

            return ResponseEntity.ok(token);

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }
}
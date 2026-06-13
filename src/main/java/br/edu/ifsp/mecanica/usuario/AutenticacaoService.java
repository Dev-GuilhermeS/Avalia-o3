package br.edu.ifsp.mecanica.usuario;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final UsuarioRepository repository;

    public AutenticacaoService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        System.out.println("BUSCANDO USUARIO: " + username);

        var usuario = repository.findByLogin(username);

        System.out.println("USUARIO ENCONTRADO: " + usuario);

        return usuario;
    }
}

package br.com.med.voll.api.infra.security;

import br.com.med.voll.api.repositories.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request); // recupero um token do cabeçalho

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT); // se tiver um cabeçalho, faz a validação
            var usuario = repository.findByLogin(subject);  // valida o token pelo usuario no banco de dados

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.get().getAuthorities()); // DTO que representa o usuario
            SecurityContextHolder.getContext().setAuthentication(authentication); // Força a autenticação
        }
        
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var autorizationHeader = request.getHeader("Authorization"); // Recuperando um token do cabeçalho autorization
        if (autorizationHeader != null) {
            return autorizationHeader.replace("Bearer ", "");
        }
        return null;
    }
}

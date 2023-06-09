package Ignite.Park.Go.controller;

import Ignite.Park.Go.domain.usuario.DadosAutenticacao;
import Ignite.Park.Go.domain.usuario.Usuario;
import Ignite.Park.Go.infra.security.DadosTokenJWT;
import Ignite.Park.Go.infra.security.SecurityFilter;
import Ignite.Park.Go.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SecurityFilter securityFilter;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return new ResponseEntity<String>("Bearer " + tokenJWT, HttpStatus.OK);
    }

    @GetMapping("/validation")
    public ResponseEntity validarTokenJWT(@RequestHeader DadosTokenJWT dados) {
        return new ResponseEntity("Token validado", HttpStatus.OK);
    }
}

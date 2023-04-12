package ignite.park.api.controller;

import ignite.park.api.domain.cliente.Cliente;
import ignite.park.api.domain.cliente.DadosAutenticacaoCliente;
import ignite.park.api.infra.security.DadosTokenJWT;
import ignite.park.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@RestController
@RequestMapping("/login")
public class AuthaticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoCliente dados) {
        System.out.println(dados.email() + "\n" + dados.password());
        var autheticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        System.out.println(autheticationToken);
        var authetication = manager.authenticate(autheticationToken);
        System.out.println(authetication);

        var tokenJWT = tokenService.gerarToken((Cliente) authetication.getPrincipal());
        System.out.println(tokenJWT);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}

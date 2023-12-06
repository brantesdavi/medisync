package medisync.api.controller;

import jakarta.validation.Valid;
import medisync.api.domain.user.AuthData;
import medisync.api.domain.user.User;
import medisync.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthData data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth =  manager.authenticate(token);

        return ResponseEntity.ok(tokenService.generateToken((User) auth.getPrincipal()));
    }

}

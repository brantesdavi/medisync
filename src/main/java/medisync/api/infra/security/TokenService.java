package medisync.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import medisync.api.domain.user.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String generateToken(User user){
        try {
            var algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API Medisync")
                    .withSubject(user.getLogin())
                    //.withClaim("id", user.getId())
                    .withExpiresAt(ExperationDate())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Error generatin token jwt", exception);
        }
    }

    private Instant ExperationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}

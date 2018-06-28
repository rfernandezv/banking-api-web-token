
package banking.user.application;

import banking.common.application.Notification;
import banking.common.application.enumeration.RequestBodyType;
import banking.security.JwtTokenProvider;
import banking.user.application.dto.RequestLoginDto;
import banking.user.application.dto.RequestUserDto;
import banking.user.domain.entity.Role;
import banking.user.domain.entity.User;
import banking.user.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service()
public class UserApplicationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(RequestLoginDto requestLoginDto) throws Exception  {
        
        Notification notification = this.validationLogin(requestLoginDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }        
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestLoginDto.getUsername(), requestLoginDto.getPassword()));
        } catch (Exception e) {
            notification.addError("Acceso denegado");
        }        
        return jwtTokenProvider.createToken(requestLoginDto.getUsername(), userRepository.findByUsername(requestLoginDto.getUsername()).getRoles());
    }    
    
    @Transactional
    public void signup(RequestUserDto requestUserDto) throws Exception {
        
        Notification notification = this.validationSignUp(requestUserDto);
        if (notification.hasErrors()) {
            throw new IllegalArgumentException(notification.errorMessage());
        }
        
        User admin = new User();
        admin.setUsername(requestUserDto.getUsername());
        admin.setPassword(requestUserDto.getPassword());
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setEmail(requestUserDto.getEmail());        
        userRepository.save(admin);
        String token = jwtTokenProvider.createToken(admin.getUsername(), admin.getRoles());       
    }
    
    private Notification validationLogin(RequestLoginDto requestLoginDto) {
        Notification notification = new Notification();
        if (requestLoginDto == null || requestLoginDto.getRequestBodyType() == RequestBodyType.INVALID) {
            notification.addError("Invalid JSON data in request login body.");
        }
        return notification;
    }
    
    private Notification validationSignUp(RequestUserDto requestUserDto) {
        Notification notification = new Notification();
        if (requestUserDto == null || requestUserDto.getRequestBodyType() == RequestBodyType.INVALID) {
            notification.addError("Invalid JSON data in request user body.");
        }
        return notification;
    }
}

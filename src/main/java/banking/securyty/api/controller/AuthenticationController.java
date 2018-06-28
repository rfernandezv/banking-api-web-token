package banking.securyty.api.controller;
import banking.common.api.controller.ResponseHandler;
import banking.security.JwtAuthenticationResponse;
import banking.user.application.UserApplicationService;
import banking.user.application.dto.RequestLoginDto;
import banking.user.application.dto.RequestUserDto;
import banking.user.domain.entity.Role;
import banking.user.domain.entity.User;
import banking.user.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {
    @Autowired
    ResponseHandler responseHandler;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private UserApplicationService userApplicationService;
    
    @RequestMapping("/login")
    public ResponseEntity<Object> login(@RequestBody RequestLoginDto requestLoginDto) throws Exception {
        try {
            String jwt = userApplicationService.signin(requestLoginDto);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
        } catch(IllegalArgumentException ex) {
                return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
        } catch(Exception ex) {
                return this.responseHandler.getAppExceptionResponse();
        }
    }
    
    @RequestMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody RequestUserDto requestUserDto) throws Exception {
        try {
            userApplicationService.signup(requestUserDto);
            return this.responseHandler.getOkCommandResponse("User registered!");
        } catch(IllegalArgumentException ex) {
                return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
        } catch(Exception ex) {
                return this.responseHandler.getAppExceptionResponse();
        }
    }
}

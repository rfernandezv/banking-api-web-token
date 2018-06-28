package banking.user.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import banking.common.application.dto.RequestBaseDto;
import banking.common.application.enumeration.RequestBodyType;
import banking.user.application.dto.deserializer.RequestUserDtoDeserializer;

@JsonDeserialize(using = RequestUserDtoDeserializer.class)
public class RequestUserDto extends RequestBaseDto {
    private String username;
    private String password;
    private String email;

    public RequestUserDto() {
    }    
    
    public RequestUserDto(String username, String password, String email, RequestBodyType requestBodyType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.requestBodyType = requestBodyType;
    }    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

package banking.user.application.dto;

import banking.common.application.dto.RequestBaseDto;
import banking.common.application.enumeration.RequestBodyType;
import banking.user.application.dto.deserializer.RequestLoginDtoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = RequestLoginDtoDeserializer.class)
public class RequestLoginDto extends RequestBaseDto{
     private String username;
    private String password;

    public RequestLoginDto() {
    }    
    
    public RequestLoginDto(String username, String password, RequestBodyType requestBodyType) {
        this.username = username;
        this.password = password;
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
    
    
}

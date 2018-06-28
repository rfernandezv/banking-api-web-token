package banking.user.application.dto.deserializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import banking.common.application.enumeration.RequestBodyType;
import banking.user.application.dto.RequestUserDto;

public class RequestUserDtoDeserializer extends JsonDeserializer<RequestUserDto>{

    @Override
    public RequestUserDto deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        RequestUserDto requestUserDto = null;
	try {
            ObjectCodec objectCodec = jsonParser.getCodec();
            JsonNode node = objectCodec.readTree(jsonParser);
            String username = node.get("username").asText();
            String password = node.get("password").asText();
            String email = node.get("email").asText();
            requestUserDto = new RequestUserDto(username, password, email,  RequestBodyType.VALID);
    	} catch(Exception ex) {
    		requestUserDto = new RequestUserDto("", "", "", RequestBodyType.INVALID);
    	}
        return requestUserDto;
    }
    
}

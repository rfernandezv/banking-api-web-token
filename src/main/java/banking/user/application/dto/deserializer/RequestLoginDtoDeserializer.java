package banking.user.application.dto.deserializer;

import banking.common.application.enumeration.RequestBodyType;
import banking.user.application.dto.RequestLoginDto;
import banking.user.application.dto.RequestUserDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;


public class RequestLoginDtoDeserializer extends JsonDeserializer<RequestLoginDto> {
     
    @Override
    public RequestLoginDto deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
        RequestLoginDto requestLoginDto = null;
	try {
            ObjectCodec objectCodec = jsonParser.getCodec();
            JsonNode node = objectCodec.readTree(jsonParser);
            String username = node.get("username").asText();
            String password = node.get("password").asText();
            requestLoginDto = new RequestLoginDto(username, password,  RequestBodyType.VALID);
    	} catch(Exception ex) {
    		requestLoginDto = new RequestLoginDto("", "", RequestBodyType.INVALID);
    	}
        return requestLoginDto;
    }
}

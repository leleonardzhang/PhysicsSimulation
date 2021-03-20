package data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataMapper {
	private ObjectMapper mapper = new ObjectMapper();
	
	public String toJson(Object o) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
		} catch (JsonProcessingException e) {

		}
		return null;
	}
	
	public Object toObject(String str, Class c) {
		try {
			return mapper.readValue(str, c);
		} catch (JsonProcessingException e) {
			
		}
		return null;
	}
}

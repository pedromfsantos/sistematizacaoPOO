package deserializers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class StringListTrimDeserializer extends StdDeserializer<List<String>> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected StringListTrimDeserializer() {
        super(List.class);
    }

    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode array = deserializationContext.readTree(jsonParser);
        List<String> filtered = new ArrayList<>();

        for(JsonNode node : array){
            String str = node.textValue();
            if(!str.isBlank()){
                filtered.add(str);
            }
        }

        return filtered;
    }
}
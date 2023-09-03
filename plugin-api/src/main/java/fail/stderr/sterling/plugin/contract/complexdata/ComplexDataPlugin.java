package fail.stderr.sterling.plugin.contract.complexdata;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fail.stderr.sterling.plugin.data.ComplexDataValue;

public interface ComplexDataPlugin<T extends ComplexDataValue<?>> {

//   JsonNode serialize(@NotNull T value) throws Exception;
//
//   T deserialize(@NotNull JsonNode jsonNode, @NotNull Class<T> type) throws Exception;

  StdSerializer<T> createSerializer();

  StdDeserializer<T> createDeserializer();

  Class<T> getType();

}

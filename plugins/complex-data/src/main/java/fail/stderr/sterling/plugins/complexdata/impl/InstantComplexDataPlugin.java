package fail.stderr.sterling.plugins.complexdata.impl;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPlugin;
import fail.stderr.sterling.plugins.complexdata.data.InstantComplexDataValue;

import java.io.IOException;
import java.time.Instant;

public class InstantComplexDataPlugin implements ComplexDataPlugin<InstantComplexDataValue> {

  @Override
  public StdSerializer<InstantComplexDataValue> createSerializer() {
    return new Serializer();
  }

  @Override
  public StdDeserializer<InstantComplexDataValue> createDeserializer() {
    return new Deserializer();
  }

  @Override
  public Class<InstantComplexDataValue> getType() {
    return InstantComplexDataValue.class;
  }

  public static class Serializer extends StdSerializer<InstantComplexDataValue> {

    protected Serializer() {
      super(InstantComplexDataValue.class);
    }

    @Override
    public void serialize(InstantComplexDataValue value, JsonGenerator gen, SerializerProvider provider) throws IOException {

      final Instant instant = value.getValue();
      final String instantAsISO8601 = instant.toString();
      gen.writeStartObject();
      gen.writeStringField("iso8601", instantAsISO8601);
      gen.writeEndObject();

    }
  }

  protected static class Deserializer extends StdDeserializer<InstantComplexDataValue> {

    protected Deserializer() {
      super(InstantComplexDataValue.class);
    }

    @Override
    public InstantComplexDataValue deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JacksonException {
      final TreeNode tree = p.readValueAsTree();
      final TreeNode iso8601node = tree.get("iso8601");
      if (iso8601node instanceof TextNode) {
        final String iso8601string = ((TextNode) iso8601node).asText();
        final Instant instant = Instant.parse(iso8601string);
        return new InstantComplexDataValue(instant);
      }
      return null;
    }
  }

}

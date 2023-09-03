package fail.stderr.sterling.plugins.complexdata.impl;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPlugin;
import fail.stderr.sterling.plugins.complexdata.data.InstantComplexDataValue;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.time.Instant;

public class InstantComplexDataPlugin implements ComplexDataPlugin<InstantComplexDataValue> {

  @Override
  public @NotNull StdSerializer<InstantComplexDataValue> createSerializer() {
    return new Serializer();
  }

  @Override
  public @NotNull StdDeserializer<InstantComplexDataValue> createDeserializer() {
    return new Deserializer();
  }

  @Override
  public @NotNull Class<InstantComplexDataValue> getType() {
    return InstantComplexDataValue.class;
  }

  public static class Serializer extends StdSerializer<InstantComplexDataValue> {

    protected Serializer() {
      super(InstantComplexDataValue.class);
    }

    @Override
    public void serialize(InstantComplexDataValue value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      // NOTE: we don't need to start/end the object because serializeWithType is doing that

      final Instant instant = value.getValue();
      final String instantAsISO8601 = instant.toString();
      gen.writeStringField("value", instantAsISO8601);
    }

    @Override
    public void serializeWithType(InstantComplexDataValue value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
      // this will start an object, write an @class field w/ type info for polymorphic deserialization support
      final WritableTypeId typeId = typeSer.typeId(value, JsonToken.START_OBJECT);
      final WritableTypeId writtenType = typeSer.writeTypePrefix(gen, typeId);
      serialize(value, gen, provider);
      // this will end the object
      typeSer.writeTypeSuffix(gen, writtenType);
    }
  }

  protected static class Deserializer extends StdDeserializer<InstantComplexDataValue> {

    protected Deserializer() {
      super(InstantComplexDataValue.class);
    }

    @Override
    public InstantComplexDataValue deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JacksonException {
      final TreeNode tree = p.readValueAsTree();
      final TreeNode iso8601node = tree.get("value");
      if (iso8601node instanceof TextNode) {
        final String iso8601string = ((TextNode) iso8601node).asText();
        final Instant instant = Instant.parse(iso8601string);
        return new InstantComplexDataValue(instant);
      }
      return null;
    }
  }

}

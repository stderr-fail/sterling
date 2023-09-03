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
import fail.stderr.sterling.plugins.complexdata.data.BigDecimalComplexDataValue;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.math.BigDecimal;

public class BigDecimalComplexDataPlugin implements ComplexDataPlugin<BigDecimalComplexDataValue> {

  @Override
  @NotNull
  public StdSerializer<BigDecimalComplexDataValue> createSerializer() {
    return new Serializer();
  }

  @Override
  @NotNull
  public StdDeserializer<BigDecimalComplexDataValue> createDeserializer() {
    return new Deserializer();
  }

  @Override
  @NotNull
  public Class<BigDecimalComplexDataValue> getType() {
    return BigDecimalComplexDataValue.class;
  }

  public static class Serializer extends StdSerializer<BigDecimalComplexDataValue> {

    protected Serializer() {
      super(BigDecimalComplexDataValue.class);
    }

    @Override
    public void serialize(BigDecimalComplexDataValue value, JsonGenerator gen, SerializerProvider provider) throws IOException {
      // NOTE: we don't need to start/end the object because serializeWithType is doing that

      final BigDecimal decimal = value.getValue();
      final String decimalString = decimal.toPlainString();
      gen.writeStringField("value", decimalString);
    }

    @Override
    public void serializeWithType(BigDecimalComplexDataValue value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer) throws IOException {
      // this will start an object, write an @class field w/ type info for polymorphic deserialization support
      final WritableTypeId typeId = typeSer.typeId(value, JsonToken.START_OBJECT);
      final WritableTypeId writtenType = typeSer.writeTypePrefix(gen, typeId);
      serialize(value, gen, provider);
      // this will end the object
      typeSer.writeTypeSuffix(gen, writtenType);
    }
  }

  protected static class Deserializer extends StdDeserializer<BigDecimalComplexDataValue> {

    protected Deserializer() {
      super(BigDecimalComplexDataValue.class);
    }

    @Override
    public BigDecimalComplexDataValue deserialize(JsonParser p, DeserializationContext ctx) throws IOException, JacksonException {
      final TreeNode tree = p.readValueAsTree();
      final TreeNode decimalNode = tree.get("value");
      if (decimalNode instanceof TextNode) {
        final String decimalString = ((TextNode) decimalNode).asText();
        final BigDecimal decimal = new BigDecimal(decimalString);
        return new BigDecimalComplexDataValue(decimal);
      }
      return null;
    }
  }

}

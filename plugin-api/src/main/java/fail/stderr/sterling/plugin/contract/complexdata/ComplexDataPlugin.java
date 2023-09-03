package fail.stderr.sterling.plugin.contract.complexdata;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fail.stderr.sterling.plugin.data.ComplexDataValue;
import org.jetbrains.annotations.NotNull;

public interface ComplexDataPlugin<T extends ComplexDataValue<?>> {

  /**
   * Create a Jackson {@link JsonSerializer} for {@link T}
   * <p/>
   * <b>IMPORTANT!!</b> The {@link JsonSerializer} created by this method <b>MUST</b> support polymorphic serialization! To do this, typically
   * it means that your serializer overrides and implements {@link StdSerializer#serializeWithType}
   * <p/>
   * Look at the default ComplexDataValue plugins (such as InstantComplexDataPlugin) for a concrete example
   *
   * @return A {@link JsonSerializer} for {@link T} with polymorphic serialization support
   */
  @NotNull
  JsonSerializer<T> createSerializer();

  /**
   * Create a Jackson {@link JsonDeserializer} for {@link T}
   *
   * @return A {@link JsonDeserializer} for {@link T}
   */
  @NotNull
  JsonDeserializer<T> createDeserializer();

  /**
   * Return a concrete type reference to {@link T}
   * @return A {@link Class<T>} reference
   */
  @NotNull
  Class<T> getType();

}

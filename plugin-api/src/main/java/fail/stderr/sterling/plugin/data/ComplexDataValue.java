package fail.stderr.sterling.plugin.data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.jetbrains.annotations.NotNull;

/**
 * Marker interface for complex data types provided by plugins.
 * <p>
 * It contains class type metadata in the serialized "@class" field so that Jackson can deserialize it polymorphic-ally
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public interface ComplexDataValue<T> {

  @NotNull
  T getValue();

  void setValue(@NotNull T value);

}

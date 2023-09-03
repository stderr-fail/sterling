package fail.stderr.sterling.plugin.data;

import org.jetbrains.annotations.NotNull;

/**
 * Marker interface for complex data types provided by plugins
 */
public interface ComplexDataValue<T> {

  @NotNull
  T getValue();

  void setValue(@NotNull T value);

}

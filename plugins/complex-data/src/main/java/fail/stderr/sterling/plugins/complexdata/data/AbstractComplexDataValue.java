package fail.stderr.sterling.plugins.complexdata.data;

import fail.stderr.sterling.plugin.data.ComplexDataValue;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractComplexDataValue<T> implements ComplexDataValue<T> {

  @NotNull
  protected T value;

  public AbstractComplexDataValue(@NotNull T value) {
    this.value = value;
  }

  @Override
  public @NotNull T getValue() {
    return value;
  }

  @Override
  public void setValue(@NotNull T value) {

  }
}

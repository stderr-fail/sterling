package fail.stderr.sterling.plugin.persistence;

import fail.stderr.sterling.plugin.data.ComplexDataValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PluginDataRepository {

  void unset(@NotNull String prop);

  void setString(@NotNull String prop, @NotNull String value);

  @Nullable String getString(@NotNull String prop);

  void setBoolean(@NotNull String prop, @NotNull Boolean value);

  @Nullable Boolean getBoolean(@NotNull String prop);

  void setInteger(@NotNull String prop, @NotNull Integer value);

  @Nullable Integer getInteger(@NotNull String prop);

  void setLong(@NotNull String prop, @NotNull Long value);

  @Nullable Long getLong(@NotNull String prop);

  <T, CDV extends ComplexDataValue<T>> void setComplexValue(@NotNull String prop, @NotNull CDV value);

  <T, CDV extends ComplexDataValue<T>> @Nullable T getComplexValue(@NotNull String prop, @NotNull Class<CDV> type);

}

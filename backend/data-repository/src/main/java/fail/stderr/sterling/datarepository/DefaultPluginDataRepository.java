package fail.stderr.sterling.datarepository;

import fail.stderr.sterling.plugin.data.ComplexDataValue;
import fail.stderr.sterling.plugin.persistence.PluginDataRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Instance-based data for a single plugin
 */
public class DefaultPluginDataRepository implements PluginDataRepository {


  @Override
  public void unset(@NotNull String prop) {

  }

  @Override
  public void setString(@NotNull String prop, @NotNull String value) {

  }

  @Override
  public @Nullable String getString(@NotNull String prop) {
    return null;
  }

  @Override
  public void setBoolean(@NotNull String prop, @NotNull Boolean value) {

  }

  @Override
  public @Nullable Boolean getBoolean(@NotNull String prop) {
    return null;
  }

  @Override
  public void setInteger(@NotNull String prop, @NotNull Integer value) {

  }

  @Override
  public @Nullable Integer getInteger(@NotNull String prop) {
    return null;
  }

  @Override
  public void setLong(@NotNull String prop, @NotNull Long value) {

  }

  @Override
  public @Nullable Long getLong(@NotNull String prop) {
    return null;
  }

  @Override
  public <T, CDV extends ComplexDataValue<T>> void setComplexValue(@NotNull String prop, @NotNull CDV value) {

  }

  @Override
  public <T, CDV extends ComplexDataValue<T>> @Nullable T getComplexValue(@NotNull String prop, @NotNull Class<CDV> type) {
    return null;
  }
}

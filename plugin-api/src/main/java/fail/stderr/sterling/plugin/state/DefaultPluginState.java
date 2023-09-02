package fail.stderr.sterling.plugin.state;

import java.util.Map;

public class DefaultPluginState implements PluginState {

  protected final Map<String, Object> data;

  public DefaultPluginState(Map<String, Object> data) {
    this.data = data;
  }

  @Override
  public <T> T getProperty(String key, Class<T> type) {
    return null;
  }

  @Override
  public Integer getIntegerProperty(String key) {
    return PluginState.super.getIntegerProperty(key);
  }

  @Override
  public Long getLongProperty(String key) {
    return PluginState.super.getLongProperty(key);
  }

  @Override
  public Boolean getBooleanProperty(String key) {
    return PluginState.super.getBooleanProperty(key);
  }

  @Override
  public String getStringProperty(String key) {
    return PluginState.super.getStringProperty(key);
  }
}

package fail.stderr.sterling.plugin.state;

public interface PluginState {

  <T> T getProperty(String key, Class<T> type);

  default Integer getIntegerProperty(String key) {
    return getProperty(key, Integer.class);
  }

  default Long getLongProperty(String key) {
    return getProperty(key, Long.class);
  }

  default Boolean getBooleanProperty(String key) {
    return getProperty(key, Boolean.class);
  }

  default String getStringProperty(String key) {
    return getProperty(key, String.class);
  }

}

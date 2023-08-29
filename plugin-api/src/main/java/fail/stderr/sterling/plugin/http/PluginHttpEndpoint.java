package fail.stderr.sterling.plugin.http;

/**
 * The contract to provide a method which handles an HTTP endpoint
 */
public interface PluginHttpEndpoint {

  Method getMethod();

  /**
   * This will be prefixed with "/plugins/${PLUGIN_NAME}"
   * <p>
   * Each path must start with "/"
   */
  String[] getPaths();

  Object getHandler();

  /**
   * The function which processes the web request
   *
   * @return
   */
  java.lang.reflect.Method getHandlerMethod();


  enum Method {
    GET, POST, PUT, DELETE
  }

}

package fail.stderr.sterling.plugin;


import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public interface Plugin {

  default List<PluginHttpEndpoint> getHttpEndpoints() {
    return Collections.emptyList();
  }

  default PluginHttpEndpoint createHttpEndpoint(PluginHttpEndpoint.Method method, String paths, Object handler, Method handlerMethod) {
    return createHttpEndpoint(method, new String[]{paths}, handler, handlerMethod);
  }

  default PluginHttpEndpoint createHttpEndpoint(PluginHttpEndpoint.Method method, String[] paths, Object handler, Method handlerMethod) {
    return new PluginHttpEndpoint() {
      @Override
      public Method getMethod() {
        return method;
      }

      @Override
      public String[] getPaths() {
        return paths;
      }

      @Override
      public Object getHandler() {
        return handler;
      }

      @Override
      public java.lang.reflect.Method getHandlerMethod() {
        return handlerMethod;
      }
    };
  }

  default Method methodRef(String methodName) {
    return methodRef(this, methodName);
  }

  default Method methodRef(Object o, String methodName) {
    try {
      return o.getClass().getMethod(methodName);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

}

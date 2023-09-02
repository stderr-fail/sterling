package fail.stderr.sterling.plugin.contractold;

import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;

import java.lang.reflect.Method;
import java.util.*;

public interface HttpPlugin {

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
    final Optional<Method> method = Arrays.stream(o.getClass().getMethods()).filter(it -> Objects.equals(it.getName(), methodName)).findFirst();
    return method.orElseThrow(() -> new NoSuchElementException("didn't find method with name '" + methodName + "'"));
  }

}

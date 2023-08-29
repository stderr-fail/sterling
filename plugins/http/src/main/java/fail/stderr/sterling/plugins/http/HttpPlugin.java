package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.IPlugin;
import fail.stderr.sterling.plugin.http.IPluginHttpEndpoint;
import fail.stderr.sterling.plugin.http.response.IPluginHttpResponse;
import fail.stderr.sterling.plugin.http.response.ViewPluginHttpResponse;
import fail.stderr.sterling.plugin.registrars.IPluginHttpRegistrar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class HttpPlugin implements IPlugin {

  public HttpPlugin() {
    System.out.println("here!");
  }

  @Override
  public void registerHttpEndpoints(IPluginHttpRegistrar registrar) {
    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/config", this, safeMethod("httpConfig"));
    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/streaming", this, safeMethod("streaming"));
    registrar.registerEndpoint(IPluginHttpEndpoint.Methods.GET, "/plugins/http/stream-data", this, safeMethod("streamData"));
  }

  public IPluginHttpResponse httpConfig() {
    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    return new ViewPluginHttpResponse("plugins/http/config", data);
  }

  public IPluginHttpResponse streaming() {

    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");

    return new ViewPluginHttpResponse("plugins/http/streaming", data);
  }

  public IPluginHttpResponse streamData() {

    final ArrayList<CustomData> list = new ArrayList<>();
    for (int i = 0; i < 2000; i++) {
      list.add(new CustomData(i));
    }

    final Stream<CustomData> stream = list.stream();

    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    data.put("list", list);
    data.put("stream", stream);

    return new ViewPluginHttpResponse("plugins/http/stream-data", data);
  }

}

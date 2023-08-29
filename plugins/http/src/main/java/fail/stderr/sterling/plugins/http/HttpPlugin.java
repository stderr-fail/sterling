package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.Plugin;
import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;
import fail.stderr.sterling.plugin.http.response.IPluginHttpResponse;
import fail.stderr.sterling.plugin.http.response.ViewPluginHttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class HttpPlugin implements Plugin {

  public HttpPlugin() {
    System.out.println("here!");
  }

  @Override
  public List<PluginHttpEndpoint> getHttpEndpoints() {
    final ArrayList<PluginHttpEndpoint> endpoints = new ArrayList<>();
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/config", this, methodRef("httpConfig")));
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/streaming", this, methodRef("streaming")));
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/stream-data", this, methodRef("streamData")));
    return endpoints;
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

package fail.stderr.sterling.plugins.http;

import fail.stderr.sterling.plugin.Plugin;
import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class HttpPlugin implements Plugin {

  public HttpPlugin() {
    System.out.println("here!");
  }

  @Override
  public List<PluginHttpEndpoint> getHttpEndpoints() {
    final ArrayList<PluginHttpEndpoint> endpoints = new ArrayList<>();

    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/raw", this, methodRef("raw")));
//    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/modelandview", this, methodRef("modelAndView")));
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/config", this, methodRef("httpConfig")));
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/streaming", this, methodRef("streaming")));
    endpoints.add(createHttpEndpoint(PluginHttpEndpoint.Method.GET, "/plugins/http/stream-data", this, methodRef("streamData")));
    return endpoints;
  }

  public void raw(HttpServletResponse r) throws IOException {
    r.setHeader("Content-Type", "text/markdown;charset=utf-8");
    try (final ServletOutputStream out = r.getOutputStream()) {
      out.write("# HttpServletResponse woo!".getBytes(StandardCharsets.UTF_8));
    }
  }

  public String httpConfig(HttpServletRequest req, HttpServletResponse res) {
    final HashMap<String, Object> data = new HashMap<>();
    data.put("a", "hello world");
    return "plugins/http/config";
  }

  public String streaming(Map<String, String> model) {

    model.put("a", "hello world");

    return "plugins/http/streaming";
  }

  public String streamData(Map<String, Object> model) {

    final ArrayList<CustomData> list = new ArrayList<>();
    for (int i = 0; i < 2000; i++) {
      list.add(new CustomData(i));
    }

    final Stream<CustomData> stream = list.stream();

    model.put("a", "hello world");
    model.put("list", list);
    model.put("stream", stream);

    return "plugins/http/stream-data";
  }

}

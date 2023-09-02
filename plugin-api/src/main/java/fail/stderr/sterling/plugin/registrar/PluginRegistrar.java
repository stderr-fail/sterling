package fail.stderr.sterling.plugin.registrar;

import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;

public interface PluginRegistrar {

  void registerEndpoint(PluginHttpEndpoint endpoint);

}

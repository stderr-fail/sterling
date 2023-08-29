package fail.stderr.sterling.plugin.registrars;

import fail.stderr.sterling.plugin.http.PluginHttpEndpoint;

public interface PluginRegistrar {

  void registerEndpoint(PluginHttpEndpoint endpoint);

}

package fail.stderr.sterling.plugins

import fail.stderr.sterling.plugin.Plugin
import fail.stderr.sterling.plugin.contractold.HttpPlugin
import fail.stderr.sterling.plugin.contractold.PropConverterPlugin
import fail.stderr.sterling.plugin.http.PluginHttpEndpoint
import fail.stderr.sterling.plugin.propconverter.PropConverter
import fail.stderr.sterling.plugin.registrar.PluginRegistrar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.util.pattern.PathPatternParser

@Service
class PluginRegistrar : PluginRegistrar {

  @Autowired
  lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  val plugins: MutableList<Plugin> = mutableListOf()
  val propConverters: MutableList<PropConverter<*, *>> = mutableListOf()

  fun register(plugin: Plugin) {
    synchronized(plugins) { plugins.add(plugin) }
  }

  fun start() {
    processHttpPlugins();
    processPropConverterPlugins();
  }

  protected fun processHttpPlugins() {
    plugins.filterIsInstance(HttpPlugin::class.java).forEach { plugin ->
      plugin.httpEndpoints?.forEach(::registerEndpoint)
    }
  }

  protected fun processPropConverterPlugins() {
    plugins.filterIsInstance(PropConverterPlugin::class.java).forEach { plugin ->
      propConverters.addAll(plugin.propConverters);
    }
  }

  override fun registerEndpoint(endpoint: PluginHttpEndpoint) {

    val options = RequestMappingInfo.BuilderConfiguration()
    options.patternParser = PathPatternParser()

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths(*endpoint.paths)
        .methods(RequestMethod.resolve(endpoint.method.name))
        .options(options)
        .build(),
      endpoint.handler,
      endpoint.handlerMethod,
    )

  }

}
package fail.stderr.sterling.plugins

import fail.stderr.sterling.plugin.Plugin
import fail.stderr.sterling.plugin.http.PluginHttpEndpoint
import fail.stderr.sterling.plugin.registrars.PluginRegistrar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.util.pattern.PathPatternParser
import kotlin.reflect.jvm.javaMethod

@Service
class PluginRegistrar : PluginRegistrar {

  @Autowired
  lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  val plugins: MutableList<Plugin> = mutableListOf()

  fun register(plugin: Plugin) {
    synchronized(plugins) { plugins.add(plugin) }
  }

  fun start() {
    plugins.forEach { plugin ->
      plugin.httpEndpoints?.forEach(::registerEndpoint)
    }
  }

  override fun registerEndpoint(endpoint: PluginHttpEndpoint) {

    val options = RequestMappingInfo.BuilderConfiguration()
    options.patternParser = PathPatternParser()

    val proxy = PluginRequestProxy(endpoint)

    requestMappingHandlerMapping.registerMapping(
      RequestMappingInfo
        .paths(*endpoint.paths)
        .methods(RequestMethod.resolve(endpoint.method.name))
        .options(options)
        .build(),
      proxy,
      PluginRequestProxy::execute.javaMethod!!,
    )

  }

}
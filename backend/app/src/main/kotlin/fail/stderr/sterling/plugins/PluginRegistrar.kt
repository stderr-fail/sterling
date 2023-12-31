package fail.stderr.sterling.plugins

import fail.stderr.sterling.plugin.Plugin
import fail.stderr.sterling.plugin.contractold.HttpPlugin
import fail.stderr.sterling.plugin.http.PluginHttpEndpoint
import fail.stderr.sterling.plugin.registrar.PluginRegistrar
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.method.RequestMappingInfo
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
import org.springframework.web.util.pattern.PathPatternParser
import java.util.*

class PluginRegistrar : PluginRegistrar {

  @Autowired
  lateinit var requestMappingHandlerMapping: RequestMappingHandlerMapping

  val plugins: MutableList<Plugin> = mutableListOf()

  @PostConstruct
  fun init() {

    val plugins = ServiceLoader.load(Plugin::class.java)
    plugins.forEach(::register)
    start()

  }


  fun register(plugin: Plugin) {
    synchronized(plugins) { plugins.add(plugin) }
  }

  fun start() {
    processHttpPlugins();
  }

  protected fun processHttpPlugins() {
    plugins.filterIsInstance(HttpPlugin::class.java).forEach { plugin ->
      plugin.httpEndpoints?.forEach(::registerEndpoint)
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
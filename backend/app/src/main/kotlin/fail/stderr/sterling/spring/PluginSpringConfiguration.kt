package fail.stderr.sterling.spring

import fail.stderr.sterling.plugin.Plugin
import fail.stderr.sterling.plugins.PluginRegistrar
import jakarta.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class PluginSpringConfiguration {

  @Autowired
  private lateinit var pluginRegistrar: PluginRegistrar

  @PostConstruct
  fun init() {
    val plugins = ServiceLoader.load(Plugin::class.java)
    plugins.forEach(pluginRegistrar::register)
    pluginRegistrar.start()

  }

}
package fail.stderr.sterling.spring

import jakarta.annotation.PostConstruct
import fail.stderr.sterling.plugin.IPlugin
import fail.stderr.sterling.plugin.Plugin
import fail.stderr.sterling.plugins.PluginRegistrar
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import java.util.*


@Configuration
class PluginSpringConfiguration {

  @Autowired
  private lateinit var pluginRegistrar: PluginRegistrar

  @PostConstruct
  fun init() {
    val plugins = ServiceLoader.load(IPlugin::class.java)
    plugins.forEach(pluginRegistrar::register)
    pluginRegistrar.start()


    val plugins2 = ServiceLoader.load(Plugin::class.java)
    plugins2.forEach {
      println("here!")
    }
  }

}
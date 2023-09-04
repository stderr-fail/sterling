package fail.stderr.sterling.spring

import fail.stderr.sterling.plugins.PluginRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class PluginSpringConfiguration {

  @Bean
  fun pluginRegistrar() = PluginRegistrar()


}
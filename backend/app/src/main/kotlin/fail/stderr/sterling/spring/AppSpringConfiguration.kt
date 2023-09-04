package fail.stderr.sterling.spring

import fail.stderr.sterling.plugins.PluginRegistrar
import fail.stderr.sterling.workspace.WorkspaceManager
import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AppSpringConfiguration {

  @Bean
  fun pluginRegistrar() = PluginRegistrar()

  @Bean
  fun workspaceManager(@Autowired beanFactory: BeanFactory) = WorkspaceManager(beanFactory)

}
package fail.stderr.sterling.workspace

import fail.stderr.sterling.model.Workspace
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import java.io.File

@Configuration
class WorkspaceFactoryConfiguration {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  fun workspace(basedir: File): Workspace {
    val o = DefaultWorkspace(basedir = basedir)
    return o
  }

}
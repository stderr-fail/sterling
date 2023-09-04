package fail.stderr.sterling.workspace

import fail.stderr.sterling.model.Workspace
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component
import java.io.File

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
class DefaultWorkspace(
  @Suppress("SpringJavaInjectionPointsAutowiringInspection") val basedir: File,
) : Workspace {

  @Autowired
  private lateinit var ctx: ApplicationContext

  override fun getWorkspaceDirectory(): File {
    TODO("Not yet implemented")
  }
}
package fail.stderr.sterling.workspace

import fail.stderr.sterling.model.Workspace
import org.springframework.beans.factory.BeanFactory
import java.io.File

class WorkspaceManager(
  val beanFactory: BeanFactory
) {

  var current: Workspace? = null

  fun setupWorkspace(basedir: File) {
    current = beanFactory.getBean(Workspace::class.java, File("Desktop"))
  }

}
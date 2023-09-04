package fail.stderr.sterling.workspace

import fail.stderr.sterling.model.Workspace
import java.io.File

class DefaultWorkspace(
  val basedir: File,
) : Workspace {


  override fun getWorkspaceDirectory(): File {
    TODO("Not yet implemented")
  }
}
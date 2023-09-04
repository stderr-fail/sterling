package fail.stderr.sterling.web.ui

import fail.stderr.sterling.workspace.WorkspaceManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import java.io.File

@Controller
@RequestMapping("/ui")
class UiTemplatesController {

  @Autowired
  lateinit var workspaceManager: WorkspaceManager

  @GetMapping(path = ["", "/", "/index.html"])
  fun index() = actual("ui/index")

  @GetMapping(path = ["/{*template}"])
  fun dynamic(@PathVariable("template") template: String) = actual("ui/${template}")

  protected fun actual(template: String): ModelAndView {
    workspaceManager.setupWorkspace(File(""))
    val mav = ModelAndView(template)
    return mav
  }

}
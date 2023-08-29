package fail.stderr.sterling.plugins

import fail.stderr.sterling.plugin.http.PluginHttpEndpoint
import fail.stderr.sterling.plugin.http.response.IPluginHttpResponse
import fail.stderr.sterling.plugin.http.response.ViewPluginHttpResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.servlet.ModelAndView

/**
 * Handles all HTTP requests for plugins
 *
 * Responsible for converting [IPluginHttpResponse] objects returned from plugins into a Spring MVC compatible type
 * in [convertToSpringResponseType]
 */
class PluginRequestProxy(
  val endpoint: PluginHttpEndpoint,
) {

  TODO: make this method take in (all?) the stuff that @ReuestMapping supports, stick it on a
  context object and pass it to a Consumer<Context> instead of a java.lang.Method so we can type it and use functional references

  fun execute(req: HttpServletRequest): Any? {

    val originalResult = endpoint.handlerMethod.invoke(endpoint.handler)

    if (originalResult is IPluginHttpResponse) {
      return convertToSpringResponseType(originalResult)
    }

    return originalResult
  }

  fun convertToSpringResponseType(original: IPluginHttpResponse): Any {

    if (original is ViewPluginHttpResponse) {
      return ModelAndView(original.viewName, original.data)
    }

    throw RuntimeException("Unsupported IPluginHttpResponse implementation of type ${original.javaClass.name}")
  }

}
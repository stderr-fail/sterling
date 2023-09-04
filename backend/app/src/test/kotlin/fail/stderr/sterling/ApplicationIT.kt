package fail.stderr.sterling

import org.springframework.boot.runApplication
import org.springframework.core.env.AbstractEnvironment

fun main(args: Array<String>) {
  System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "test,resetdb")
  runApplication<Application>(*args)
}
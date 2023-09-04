package fail.stderr.sterling.spring

import jakarta.annotation.PostConstruct
import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("resetdb")
class ResetDBConfiguration {

  @Autowired
  lateinit var flyway: Flyway

  @PostConstruct
  fun post() {
    flyway.clean()
    flyway.migrate()
  }


}
package fail.stderr.sterling.datarepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import fail.stderr.sterling.datarepository.typehandler.JsonNodeTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@MapperScan("fail.stderr.sterling.datarepository.mapper")
@Import({DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class, FlywayAutoConfiguration.class})
//@Configuration
public class DataRepositoryConfiguration {

  @Bean
  public JsonNodeTypeHandler jsonNodeTypeHandler() {
    return new JsonNodeTypeHandler(dataRepositoryObjectMapper());
  }

  @Bean
  public ObjectMapper dataRepositoryObjectMapper() {
    final ObjectMapper om = new ObjectMapper();
    return om;
  }


}

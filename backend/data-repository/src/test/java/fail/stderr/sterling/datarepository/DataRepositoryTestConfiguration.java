package fail.stderr.sterling.datarepository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration
//@MapperScan("fail.stderr.sterling.datarepository.mapper")
//@Import({DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class, FlywayAutoConfiguration.class})
@EnableAutoConfiguration
@Configuration
@Import(DataRepositoryConfiguration.class)
public class DataRepositoryTestConfiguration {



}

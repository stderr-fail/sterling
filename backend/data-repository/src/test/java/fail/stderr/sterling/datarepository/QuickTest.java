package fail.stderr.sterling.datarepository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {MybatisAutoConfiguration.class, FlywayAutoConfiguration.class})
public class QuickTest {

  @Test
  public void test() {
    System.out.println("here!");
  }

}

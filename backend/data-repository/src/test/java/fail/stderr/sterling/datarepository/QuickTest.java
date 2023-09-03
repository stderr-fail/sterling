package fail.stderr.sterling.datarepository;

import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import fail.stderr.sterling.datarepository.mapper.PluginDataMapper;
import fail.stderr.sterling.datarepository.model.PluginData;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = {DataRepositoryTestConfiguration.class})
public class QuickTest {

  @Autowired
  private Flyway flyway;

  @Autowired
  private PluginDataMapper pluginDataMapper;

  @BeforeEach
  public void beforeEach() {
    flyway.clean();
    flyway.migrate();
  }

  @Test
  public void test() {
    final ObjectNode json = new ObjectNode(JsonNodeFactory.instance);
    json.set("str", TextNode.valueOf("hello world"));
    json.set("bool", BooleanNode.valueOf(true));

    System.out.println("here!");
    final PluginData d = new PluginData();
    d.setCreated(Instant.now());
    d.setModified(Instant.now());
    d.setPluginId(UUID.randomUUID().toString());
    d.setJson(json);
    d.setVersion(1);
    pluginDataMapper.insert(d);
    System.out.println("here!");

    final List<PluginData> fromDB = pluginDataMapper.selectAll();

    System.out.println("here!");
  }

}

package fail.stderr.sterling.datarepository.model;

import com.fasterxml.jackson.databind.JsonNode;

import java.time.Instant;

public class PluginData {

  protected Long id;
  protected String pluginId;
  protected Instant created;
  protected Instant modified;
  protected Integer version;
  protected JsonNode json;

}

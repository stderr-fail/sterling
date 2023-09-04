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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPluginId() {
    return pluginId;
  }

  public void setPluginId(String pluginId) {
    this.pluginId = pluginId;
  }

  public Instant getCreated() {
    return created;
  }

  public void setCreated(Instant created) {
    this.created = created;
  }

  public Instant getModified() {
    return modified;
  }

  public void setModified(Instant modified) {
    this.modified = modified;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public JsonNode getJson() {
    return json;
  }

  public void setJson(JsonNode json) {
    this.json = json;
  }

}

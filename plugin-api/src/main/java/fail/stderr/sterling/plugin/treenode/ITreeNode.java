package fail.stderr.sterling.plugin.treenode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public interface ITreeNode {

  @JsonProperty("type")
  String getType();

  @JsonProperty("id")
  String getId();

  @JsonProperty("displayName")
  String getDisplayName();

  @JsonProperty("children")
  BaseTreeNode[] getChildren();

  @JsonProperty("data")
  Map<String, JsonNode> getData();

}

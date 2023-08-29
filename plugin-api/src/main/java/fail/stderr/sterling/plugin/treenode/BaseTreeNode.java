package fail.stderr.sterling.plugin.treenode;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Map;

public class BaseTreeNode implements ITreeNode {

  protected String type;
  protected String id;
  protected String displayName;
  protected BaseTreeNode[] children;
  protected Map<String, JsonNode> data;

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public BaseTreeNode[] getChildren() {
    return children;
  }

  public void setChildren(BaseTreeNode[] children) {
    this.children = children;
  }

  @Override
  public Map<String, JsonNode> getData() {
    return data;
  }

  public void setData(Map<String, JsonNode> data) {
    this.data = data;
  }
}

package fail.stderr.sterling.treenode

import com.fasterxml.jackson.annotation.JsonProperty

class TreeNode(
  @JsonProperty("id")
  var id: String,
  @JsonProperty("serviceType")
  var serviceType: String,
  @JsonProperty("displayName")
  var displayName: String,
  @JsonProperty("description")
  var description: String? = null,
  @JsonProperty("children")
  var children: MutableList<TreeNode>,
  @JsonProperty("data")
  var data: MutableMap<String, TreeNodeData>,
) {

}
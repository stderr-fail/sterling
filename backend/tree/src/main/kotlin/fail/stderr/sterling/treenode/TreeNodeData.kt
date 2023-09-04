package fail.stderr.sterling.treenode

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import fail.stderr.sterling.plugin.data.ComplexDataValue

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes(
  JsonSubTypes.Type(StringTreeNodeData::class),
  JsonSubTypes.Type(IntegerTreeNodeData::class),
  JsonSubTypes.Type(LongTreeNodeData::class),
  JsonSubTypes.Type(BooleanTreeNodeData::class),
  JsonSubTypes.Type(ComplexTreeNodeData::class),
)
sealed class TreeNodeData

class StringTreeNodeData(
  val value: String,
) : TreeNodeData()

class IntegerTreeNodeData(
  val value: Int,
) : TreeNodeData()

class LongTreeNodeData(
  val value: Long,
) : TreeNodeData()

class BooleanTreeNodeData(
  val value: Boolean,
) : TreeNodeData()

class ComplexTreeNodeData(
  val wrapped: ComplexDataValue<*>,
) : TreeNodeData()

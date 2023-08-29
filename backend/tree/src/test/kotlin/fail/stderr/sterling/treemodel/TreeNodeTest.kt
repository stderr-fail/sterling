package fail.stderr.sterling.treemodel

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import fail.stderr.sterling.plugin.treenode.BaseTreeNode
import org.junit.jupiter.api.Test

class TreeNodeTest {


  @Test
  fun parseJava() {

    Thread.currentThread().contextClassLoader
      .getResourceAsStream("examples/plugin.HttpRequest_01.json")
      ?.use {
        it.readAllBytes()?.decodeToString()?.let { json ->

          val om = ObjectMapper()
          om.registerModules(KotlinModule.Builder().build())

          val value = om.readValue<BaseTreeNode>(json)

          println(value)

        }
      }

  }

}
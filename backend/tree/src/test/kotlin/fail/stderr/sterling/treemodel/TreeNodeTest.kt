package fail.stderr.sterling.treemodel

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import fail.stderr.sterling.model.Workspace
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginCreateContext
import fail.stderr.sterling.plugins.complexdata.BigDecimalComplexDataPluginFactory
import fail.stderr.sterling.plugins.complexdata.InstantComplexDataPluginFactory
import fail.stderr.sterling.treenode.TreeNode
import org.junit.jupiter.api.Test
import java.io.File

class TreeNodeTest {


  @Test
  fun parseJava() {

    Thread.currentThread().contextClassLoader
      .getResourceAsStream("examples/plugin.HttpRequest_01.json")
      ?.use {
        it.readAllBytes()?.decodeToString()?.let { json ->

          val om = buildMapper()

          val value = om.readValue<TreeNode>(json)

          println(value)

          val json = om.writeValueAsString(value)
          println(json)

        }
      }

  }

  fun buildMapper(): ObjectMapper {


    val workspace = object : Workspace {
      override fun getWorkspaceDirectory(): File = File("dummy")
    }

    val createContext = object : ComplexDataPluginCreateContext {
      override fun getWorkspace() = workspace
    }

    val instantPlugin = InstantComplexDataPluginFactory().create(createContext)
    val decimalPlugin = BigDecimalComplexDataPluginFactory().create(createContext)


    val m = SimpleModule()
    m.addSerializer(instantPlugin.createSerializer())
    m.addDeserializer(instantPlugin.type, instantPlugin.createDeserializer());
    m.addSerializer(decimalPlugin.createSerializer())
    m.addDeserializer(decimalPlugin.type, decimalPlugin.createDeserializer())


    val om = ObjectMapper()
    om.registerModules(KotlinModule.Builder().build())
    om.registerModules(m)

    return om

  }

}
package fail.stderr.sterling.plugins

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginCreateContext
import fail.stderr.sterling.plugins.complexdata.InstantComplexDataPluginFactory
import fail.stderr.sterling.plugins.complexdata.data.InstantComplexDataValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Instant

class ComplexDataSerializationTest {

  @Test
  fun test() {
    println("here!")

    val plugin = InstantComplexDataPluginFactory().create(object : ComplexDataPluginCreateContext {})

    val m = SimpleModule()
    m.addSerializer(plugin.createSerializer())
    m.addDeserializer(plugin.type, plugin.createDeserializer());

    val om = ObjectMapper()
    om.registerModules(m)
    om.registerModules(KotlinModule.Builder().build())

    val now = Instant.now()
    val nowAsISO = now.toString()
    val data = Data(str = "hello", complexInstant = InstantComplexDataValue(now))

    val json = om.writeValueAsString(data)
    Assertions.assertTrue(json.contains(nowAsISO))

    val deserialized = om.readValue(json, Data::class.java)

    Assertions.assertEquals(now, deserialized.complexInstant.value)


  }

  class Data(
    var str: String,
    var complexInstant: InstantComplexDataValue
  )

}
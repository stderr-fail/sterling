package fail.stderr.sterling.plugins

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import fail.stderr.sterling.plugin.contract.complexdata.ComplexDataPluginCreateContext
import fail.stderr.sterling.plugin.data.ComplexDataValue
import fail.stderr.sterling.plugins.complexdata.BigDecimalComplexDataPluginFactory
import fail.stderr.sterling.plugins.complexdata.InstantComplexDataPluginFactory
import fail.stderr.sterling.plugins.complexdata.data.BigDecimalComplexDataValue
import fail.stderr.sterling.plugins.complexdata.data.InstantComplexDataValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.Instant

class ComplexDataSerializationTest {

  @Test
  fun test() {
    println("here!")

    val instantPlugin = InstantComplexDataPluginFactory().create(object : ComplexDataPluginCreateContext {})
    val decimalPlugin = BigDecimalComplexDataPluginFactory().create(object : ComplexDataPluginCreateContext {})

    val m = SimpleModule()
    m.addSerializer(instantPlugin.createSerializer())
    m.addDeserializer(instantPlugin.type, instantPlugin.createDeserializer());
    m.addSerializer(decimalPlugin.createSerializer())
    m.addDeserializer(decimalPlugin.type, decimalPlugin.createDeserializer())

    val om = ObjectMapper()
    om.registerModules(m)
    om.registerModules(KotlinModule.Builder().build())

    val now = Instant.now()
    val nowAsISO = now.toString()

    val complexInstant = InstantComplexDataValue(now)

    val decimal = BigDecimal("123456789.123456789")
    val complexDecimal = BigDecimalComplexDataValue(decimal)

    val data = Data(str = "hello", complex = mutableMapOf(
      "instant" to complexInstant,
      "decimal" to complexDecimal
,    )
    )

    val json = om.writeValueAsString(data)
    Assertions.assertTrue(json.contains(nowAsISO))

    val deserialized = om.readValue(json, Data::class.java)


    Assertions.assertEquals(now, deserialized.complex["instant"]?.value)
    Assertions.assertEquals(decimal, deserialized.complex["decimal"]?.value)


  }

  class Data(
    var str: String,
    var complex: MutableMap<String, ComplexDataValue<*>> = mutableMapOf()
  )

}
package fail.stderr.sterling.expression

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.expression.AccessException
import org.springframework.expression.EvaluationException
import org.springframework.expression.spel.SpelCompilerMode
import org.springframework.expression.spel.SpelParserConfiguration
import org.springframework.expression.spel.standard.SpelExpression
import org.springframework.expression.spel.standard.SpelExpressionParser
import org.springframework.expression.spel.support.ReflectiveConstructorResolver
import org.springframework.expression.spel.support.StandardEvaluationContext
import org.springframework.expression.spel.support.StandardTypeLocator
import java.lang.Boolean
import java.lang.Long

class ExpressionConstructorSafeListTest {

  @Test
  fun staticMethodSafeList() {

    val config = SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null)

    val parser = SpelExpressionParser(config)
    val intValueOfExpression = parser.parseExpression("T(java.lang.Integer).valueOf(123)") as SpelExpression
    val longValueOfExpression = parser.parseExpression("T(java.lang.Long).valueOf(123L)") as SpelExpression

    longValueOfExpression.getAST()

    val evalContext = StandardEvaluationContext()
    evalContext.setTypeLocator(
      SafeListTypeLocator(
      StandardTypeLocator(),
      arrayOf(Long::class.java)
    )
    )

    evalContext.constructorResolvers = listOf(
      SafeListReflectiveConstructorResolver(
        ReflectiveConstructorResolver(),
        emptyArray(),
      )
    )

    Assertions.assertEquals(123L, longValueOfExpression.getValue(evalContext))
    Assertions.assertThrows(AccessException::class.java) { intValueOfExpression.getValue(evalContext) }
  }

  @Test
  fun cantConstructAnythingOrUseAnyStaticMethods() {

    val parser = SpelExpressionParser()

    val newStringExpression = parser.parseExpression("new String()")
    val intValueOfExpression = parser.parseExpression("T(java.lang.Integer).valueOf(123)")


    val evalContext = StandardEvaluationContext()

    evalContext.setTypeLocator(
      SafeListTypeLocator(
      StandardTypeLocator(),
      emptyArray(),
    )
    )

    evalContext.constructorResolvers = listOf(
      SafeListReflectiveConstructorResolver(
        ReflectiveConstructorResolver(),
        emptyArray(),
      )
    )

    Assertions.assertThrows(AccessException::class.java) { intValueOfExpression.getValue(evalContext) }
    Assertions.assertThrows(EvaluationException::class.java) { newStringExpression.getValue(evalContext) }
  }

  @Test
  fun canConstructBuiltinsOnly() {

    val parser = SpelExpressionParser()
    val newStringExpression = parser.parseExpression("new String()")
    val newIntegerExpression = parser.parseExpression("new Integer('123')")
    val newLongExpression = parser.parseExpression("new Long('123')")
    val newBooleanExpression = parser.parseExpression("new Boolean(true)")

    val evalContext = StandardEvaluationContext()
    evalContext.constructorResolvers = listOf(
      SafeListReflectiveConstructorResolver(
        ReflectiveConstructorResolver(),
        arrayOf(
          java.lang.String::class.java,
          Long::class.java,
          Boolean::class.java,
        ),
      )
    )

    Assertions.assertThrows(EvaluationException::class.java) { newIntegerExpression.getValue(evalContext) }

    // these should work
    Assertions.assertEquals("", newStringExpression.getValue(evalContext))
    Assertions.assertEquals(123L, newLongExpression.getValue(evalContext))
    Assertions.assertEquals(java.lang.Boolean.TRUE, newBooleanExpression.getValue(evalContext))

  }

  class MyClass(val str: String) {
    override fun toString(): String {
      return "MyClass(str='$str')"
    }
  }
}
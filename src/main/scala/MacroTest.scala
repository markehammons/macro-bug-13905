import scala.quoted.*
import scala.util.chaining.*

object MacroTest {
  //naming Quotes resolves the compilation error
  def testImpl(using Quotes) =
    import quotes.reflect.*
    List(TypeRepr.of[Int].asType)
      .map { case '[r] =>
        '{ ${ Expr(Type.show[r]) } }
      }

  def testImpl2(using q: Quotes) =
    import quotes.reflect.*
    List(TypeRepr.of[Int].asType)
      .map { case '[r] =>
        '{ ${ Expr(Type.show[r]) } }
      }
}

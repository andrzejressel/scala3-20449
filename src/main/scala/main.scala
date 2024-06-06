import scala.quoted.*

class ForeignWrapper1[-A] {
  inline def getTypeInfo(inline source: String): Unit =
  ${ getTypeInfoImpl[A]('source) }
  def createWrapper2 = ForeignWrapper2(this)
}

class ForeignWrapper2[-A](val self: ForeignWrapper1[A]) {
  inline def getTypeInfo(inline source: String): Unit =
  ${getTypeInfoImpl[A]('source)}
}

transparent inline def getTypeInfo[T](inline source: String) =
${ getTypeInfoImpl[T]('source) }

def getTypeInfoImpl[T: Type](source: Expr[String])(using ctx: Quotes) : Expr[Unit] = {
  import ctx.reflect.*

  println("------" + source.valueOrAbort + "---------")
  val tpe = TypeRepr.of[T]
  println(s"Original: ${tpe.show}")
  println(s"Dealias: ${tpe.dealias.show}")
  println(s"Dealias dealias: ${tpe.dealias.dealias.show}")

  '{ () }
}
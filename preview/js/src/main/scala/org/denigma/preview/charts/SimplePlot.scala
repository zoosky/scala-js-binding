package org.denigma.preview.charts

import org.denigma.binding.binders.GeneralBinder
import org.denigma.controls.charts._
import org.denigma.controls.charts.ode.ODESeries
import org.scalajs.dom._
import rx._
import rx.Ctx.Owner.Unsafe.Unsafe


import scala.collection.immutable.{Seq, _}

class SimplePlot(val elem: Element) extends LinesPlot {
  self=>

  // here we create a scale for OX
  val scaleX: rx.Var[Scale] = Var(LinearScale("y", 0.0, 20.0, 1.0, 500.0))

  // here we create a scale for OY
  val scaleY: rx.Var[Scale] = Var(LinearScale("x", 0.0, 20.0, 1.0, 500.0, inverted = true))

  val justSomeLines =
    Var(
      StaticSeries("Points: [1, 1] , [2, 3], [3 ,1], [4, 3]", List(
        Point(1.0, 1.0),
        Point(2.0, 3.0),
        Point(3.0, 1.0),
        Point(4.0, 3.0)),
      LineStyles.default.copy(strokeColor = "blue")
    ))

  val lineXplus1Series = Rx {
    // line chart
    LineSeries("y = x + 1", scaleX().start, scaleX().end, LineStyles.default.copy(strokeColor = "red"))(x => Point(x, x + 1))
  }

  val lineX2 = Rx {
    // square chart
    StepSeries("y = x ^ 2", scaleX().start, scaleX().end, 0.5, LineStyles.default.copy(strokeColor = "pink", opacity = 0.5))(x => Point(x, Math.pow(x, 2)))
  }

  val derX2 = Rx {
    def ode(t: Double, y: Double): Double = 2.0 * t // solution for differential equation is t^2
    ODESeries("dy/dt = x * 2", scaleX().start, scaleX().end, 0.0, 0.01, LineStyles.default.copy(strokeColor = "yellow", opacity = 0.5))(ode)
  }

  // sequence of series
  //val items: Var[Seq[Rx[Series]]] = Var(Seq(justSomeLines, lineXplus1Series, lineX2, derX2))

  override def newItemView(key: String, value: Series): SeriesView = this.constructItemView(key){
    case (e, _) => new ItemView(e, Var(value), self.transform).withBinder(v=>new GeneralBinder(v))
  }

  override def items: Rx[scala.collection.immutable.SortedMap[String,org.denigma.controls.charts.Series]] = Rx{
    val seq: Seq[(String, Series)] = Seq(justSomeLines(), lineXplus1Series(), lineX2(), derX2()).map(s=>(s.title, s))
    SortedMap(seq:_*)
  }
}
